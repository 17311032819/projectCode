package com.cdvtc.ecommerce.web;

import com.cdvtc.ecommerce.model.CartItem;
import com.cdvtc.ecommerce.model.Product;
import com.cdvtc.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cart")
//@SessionAttributes("cart")
public class CartController {

    @Autowired
    private ProductService productService;

//    @ModelAttribute("cart")
//    public List<CartItem> initCart() {
//        List<CartItem> cart = new ArrayList<>(); // 初始化购物车
//        return cart;
//    }

    @RequestMapping("")
    public String list(Model model, HttpSession session) {
        List<CartItem> cart = (List<CartItem>)session.getAttribute("cart");
        // 计算总金额
        BigDecimal total = BigDecimal.ZERO;
        if (cart != null) {
            for (CartItem cartItem : cart) {
                total = total.add(cartItem.getTotal()); //累加汇总
            }
        }
        DecimalFormat dcf = new DecimalFormat("0.00");
        model.addAttribute("dcf", dcf);
        model.addAttribute("total", total);

        return "cart";
    }

    @RequestMapping("add/{id}")
    public String add(@PathVariable Integer id, HttpSession session){
        //从Session中获取当前购物车
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        CartItem cartItem = null;
        if(cart != null) { // 购物已存在
            cartItem = getCartIemByProductId(cart, id);
            if(cartItem != null) { // 已有购物车项，直接使用该项
                cartItem.setQuantity(cartItem.getQuantity()+1); //数量加1
            }
        } else {//购物车为空
            cart = new ArrayList<>(); // 新建购物车
            session.setAttribute("cart", cart);
        }

        if(cartItem == null) { //购物车项未创建
            cartItem = new CartItem(); //新建购物车明细项

            Product product = productService.getProductById(id);

            cartItem.setProduct(product);
            cartItem.setQuantity(1); // 默认为1
            cart.add(cartItem); //增加当前购物车项
        }

        return "redirect:/";
    }

    @RequestMapping("inc/{id}")
    public String inc(@PathVariable Integer id, HttpSession session) {
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        CartItem cartItem = getCartIemByProductId(cart, id);
        cartItem.setQuantity(cartItem.getQuantity()+1); // 数量加1
        return "redirect:/cart";
    }

    @RequestMapping("dec/{id}")
    public String dec(@PathVariable Integer id, HttpSession session) {
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        CartItem cartItem = getCartIemByProductId(cart, id);
        if(cartItem.getQuantity() > 1) {
            cartItem.setQuantity(cartItem.getQuantity()-1); // 数量减1
        }
        return "redirect:/cart";
    }

    @RequestMapping("remove/{id}")
    public String remove(@PathVariable Integer id, HttpSession session) {
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        CartItem cartItem = getCartIemByProductId(cart, id);
        cart.remove(cartItem);
        return "redirect:/cart";
    }

    /**
     * 根据产品编号查询购物车明细项
     * @param cart 购物车
     * @param productId
     * @return 未找到返回null
     */
    private CartItem getCartIemByProductId(List<CartItem> cart, int productId){
        for(CartItem cartItem: cart) {
            if(cartItem.getProduct().getId() == productId) {
                return cartItem;
            }
        }

        return null; // 未找到
    }
}
