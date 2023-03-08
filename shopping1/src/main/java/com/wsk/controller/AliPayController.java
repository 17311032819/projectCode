package com.wsk.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.wsk.pojo.GoodsOfOrderForm;
import com.wsk.pojo.OrderForm;
import com.wsk.pojo.ShopInformation;
import com.wsk.pojo.UserInformation;
import com.wsk.service.GoodsCarService;
import com.wsk.service.GoodsOfOrderFormService;
import com.wsk.service.OrderFormService;
import com.wsk.service.ShopInformationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
//@RestController
@RequestMapping("pay")
public class AliPayController {

    @Resource
    private GoodsOfOrderFormService goodsOfOrderFormService;
    @Resource
    private OrderFormService orderFormService;
    @Resource
    private GoodsCarService goodsCarService;
    /**
     * 支付接口
     *
     * @param orderId 订单id
     * @param amount  支付金额
     * @param product 商品名称
     * @param body    商品描述
     * @return
     * @throws AlipayApiException
     */
//    http://localhost:8080/pay/aliPay/11325/999.00/1/1
   @ResponseBody
   @RequestMapping("/aliPay")
    public String aliPay(@RequestParam String orderId,
                         @RequestParam String amount,
                         @RequestParam String product,
                         @RequestParam String body,
                         @RequestParam List<Integer> sidList,
                         HttpServletRequest request
                         ) throws AlipayApiException {
       System.out.println("进入支付");
       //获得个人
       UserInformation userInformation = (UserInformation) request.getSession().getAttribute("userInformation");
//获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AliPayConfig.gatewayUrl,
                AliPayConfig.app_id,
                AliPayConfig.merchant_private_key,
                "json",
                AliPayConfig.charset,
                AliPayConfig.alipay_public_key,
                AliPayConfig.sign_type);
//        page
        AlipayTradePagePayRequest alipayPageRequest = new AlipayTradePagePayRequest();
        alipayPageRequest.setReturnUrl(AliPayConfig.return_url);
        alipayPageRequest.setNotifyUrl(AliPayConfig.notify_url);
        //拼接参数
        alipayPageRequest.setBizContent("{\"out_trade_no\":\"" + orderId + "\","
                + "\"total_amount\":\"" + amount + "\","
                + "\"subject\":\"" + product + "\","
                + "\"body\":\"" + body + "\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");


       //插入订单
       OrderForm orderForm=new OrderForm();
       orderForm.setUid(userInformation.getId());
       orderForm.setContext(body);
       orderForm.setId(Integer.valueOf(orderId));
       orderForm.setDisplay(1);
       orderForm.setModified(new Date());
       orderForm.setAddress("成都市天益街83号");
       request.getServletContext().setAttribute("orderForm",orderForm);
       request.getServletContext().setAttribute("sidList",sidList);
       request.getServletContext().setAttribute("orderId",Integer.valueOf(orderId));

        return alipayClient.pageExecute(alipayPageRequest).getBody();
    }


////    http://localhost:8080/pay/notify_url
    @RequestMapping("/notify_url")  // 注意这里必须是POST接口
    public String payNotify(HttpServletRequest request, Model model) throws Exception {
        UserInformation userInformation = (UserInformation) request.getSession().getAttribute("userInformation");
        OrderForm orderForm= (OrderForm) request.getServletContext().getAttribute("orderForm");
        List<Integer> sidList= (List<Integer>) request.getServletContext().getAttribute("sidList");
        int orderId= (int) request.getServletContext().getAttribute("orderId");
        //插入订单
        goodsCarService.deleteByUid(userInformation.getId());
        orderFormService.insert(orderForm);
        //插入订单和商品表
       for (int i = 0; i < sidList.size(); i++) {
           GoodsOfOrderForm goodsOfOrderForm=new GoodsOfOrderForm();
           goodsOfOrderForm.setOfid(Integer.valueOf(orderId));
           goodsOfOrderForm.setQuantity(1);
           goodsOfOrderForm.setDisplay(1);
           goodsOfOrderForm.setSid(sidList.get(i));
           goodsOfOrderForm.setModified(new Date());
           goodsOfOrderFormService.insert(goodsOfOrderForm);
       }
        model.addAttribute("userInformation", userInformation);
        return "payReturn";
    }

    @ResponseBody
    @GetMapping("t")
    public String test(){
        System.out.println("sadadasda");
        return "ddd";
    }
}

