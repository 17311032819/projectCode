package com.wsk.controller;

import com.wsk.bean.GoodsCarBean;
import com.wsk.bean.OrdersBean;
import com.wsk.pojo.*;
import com.wsk.service.GoodsCarService;
import com.wsk.service.GoodsOfOrderFormService;
import com.wsk.service.OrderFormService;
import com.wsk.service.ShopInformationService;
import com.wsk.tool.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

//订单
@Controller
public class OrderController {
    @Resource
    private OrderFormService orderFormService;
    @Resource
    private GoodsOfOrderFormService goodsOfOrderFormService;
    @Resource
    private ShopInformationService shopInformationService;
    @Resource
    private GoodsCarService goodsCarService;

    @RequestMapping(value = "/my_orders.do")
    public String getMyOrders(HttpServletRequest request, Model model) {
        UserInformation userInformation = (UserInformation) request.getSession().getAttribute("userInformation");
        if (StringUtils.getInstance().isNullOrEmpty(userInformation)) {
            userInformation = new UserInformation();
            model.addAttribute("userInformation", userInformation);
//            list.add(shopCar);
            return "redirect:/login.do";
        } else {
            model.addAttribute("userInformation", userInformation);
        }
        int uid = userInformation.getId();
        List<OrdersBean> ordersBeans = new ArrayList<>();
        ordersBeans=orderFormService.selectByUid1(uid);
        model.addAttribute("list", ordersBeans);
        return "page/my_orders";
    }

    @RequestMapping(value = "/deleteOrder.do")
    public String deleteOrder(HttpServletRequest request, Model model,@RequestParam int gid) {
        UserInformation userInformation = (UserInformation) request.getSession().getAttribute("userInformation");
        if (StringUtils.getInstance().isNullOrEmpty(userInformation)) {
            userInformation = new UserInformation();
            model.addAttribute("userInformation", userInformation);
//            list.add(shopCar);
            return "redirect:/login.do";
        } else {
            model.addAttribute("userInformation", userInformation);
        }
        System.out.println("gid=" + gid);
        goodsOfOrderFormService.deleteByPrimaryKey(gid);
        int uid = userInformation.getId();
        List<OrdersBean> ordersBeans = new ArrayList<>();
        ordersBeans = orderFormService.selectByUid1(uid);
        model.addAttribute("list", ordersBeans);
        return "page/my_orders";
    }
    //查看订单总数
    private int getOrderFormCounts(int uid) {
        try {
            return orderFormService.getCounts(uid);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    //更新商品信息
    private String getSort(int sort) {

        return "";
    }
    //订单列表 10个
    private List<OrderForm> selectOrderFormByUid(int uid, int start) {
        try {
            return orderFormService.selectByUid(uid, (start - 1) * 10);
        } catch (Exception e) {
            e.printStackTrace();
            List<OrderForm> list = new ArrayList<>();
            list.add(new OrderForm());
            return list;
        }
    }

    //订单中的商品
    private List<GoodsOfOrderForm> selectGoodsOfOrderFormByOFid(int ofid) {
        try {
            return goodsOfOrderFormService.selectByOFid(ofid);
        } catch (Exception e) {
            e.printStackTrace();
            List<GoodsOfOrderForm> list = new ArrayList<>();
            list.add(new GoodsOfOrderForm());
            return list;
        }
    }
}
