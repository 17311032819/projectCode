package com.cdvtc.ecommerce.web;

import com.cdvtc.ecommerce.model.*;
import com.cdvtc.ecommerce.service.OrderService;
import com.cdvtc.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;

    private User getUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (User) authentication.getPrincipal();
    }

    @RequestMapping("/order")
    public String list(Model model, HttpSession session) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        DecimalFormat dcf = new DecimalFormat("#.00");
        model.addAttribute("df", df);
        model.addAttribute("dcf", dcf);

        List<Order> orders = orderService.getOrders(getUser().getId());
        model.addAttribute("orders", orders);

        return "order";
    }

    @RequestMapping("/checkout")
    public String checkout(HttpSession session) {
        ArrayList<CartItem> cart = (ArrayList<CartItem>) session.getAttribute("cart");
        if (cart != null) {
            Order order = new Order();
            List<OrderItem> orderItems = new ArrayList<>();
            BigDecimal total = new BigDecimal(0.0);
            for (CartItem cartItem : cart) {
                OrderItem orderItem = new OrderItem();
                orderItem.setProduct(cartItem.getProduct());
                orderItem.setPrice(cartItem.getProduct().getPrice()); // 复制商品价格
                orderItem.setQuantity(cartItem.getQuantity());

                orderItems.add(orderItem);
                total = total.add(cartItem.getTotal());
            }
            order.setOrderItems(orderItems);
            order.setUser(getUser());
            order.setTotal(total);

            if (orderService.addOrder(order)) {
                cart.clear();
            }
        }
        return "redirect:/order";
    }

    @RequestMapping("order/now/{id}")
    public String now(@PathVariable Integer id, @RequestParam(required = false) Integer quantity, HttpSession session) {
        if (quantity == null) {
            quantity = 1;
        }
        Order order = new Order();

        LocalDateTime localDateTime = LocalDateTime.now();
        localDateTime.toInstant(ZoneOffset.of("+8"));

        Product product = productService.getProductById(id);
        OrderItem orderItem = new OrderItem();
        orderItem.setProduct(product);
        orderItem.setPrice(product.getPrice()); //复制商品价格
        orderItem.setQuantity(quantity);

        List<OrderItem> orderItems = new ArrayList<>();
        orderItems.add(orderItem);

        order.setOrderItems(orderItems);
        order.setTotal(product.getPrice().multiply(BigDecimal.valueOf(quantity))); // 计算总价
        order.setUser(getUser());

        boolean result = orderService.addOrder(order);
        if (result) {
            ArrayList<CartItem> cart = (ArrayList<CartItem>) session.getAttribute("cart");
            if (cart != null) {
                CartItem cartItem = getCartIemByProductId(cart, id);
                if (cartItem != null) {
                    cart.remove(cartItem);
                }
            }
        }

        return "redirect:/order";
    }

    @RequestMapping("/order/cancel/{id}")
    public String cancel(@PathVariable Integer id) {
        orderService.cancelOrder(id);
        return "redirect:/order";
    }

    /**
     * 根据产品编号查询购物车明细项
     *
     * @param cart      购物车
     * @param productId
     * @return 未找到返回null
     */
    private CartItem getCartIemByProductId(List<CartItem> cart, int productId) {
        for (CartItem cartItem : cart) {
            if (cartItem.getProduct().getId() == productId) {
                return cartItem;
            }
        }

        return null; // 未找到
    }
}
