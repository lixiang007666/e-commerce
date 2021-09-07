package top.lixiang007.taotao.portal.controller;


import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import top.lixiang007.taotao.pojo.TbUser;
import top.lixiang007.taotao.portal.pojo.CartItem;
import top.lixiang007.taotao.portal.pojo.OrderInfo;
import top.lixiang007.taotao.portal.service.CartService;
import top.lixiang007.taotao.portal.service.OrderService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 提交订单Controller
 */
/**
 * @Author Xiang Li
 * @Date 2021/9/7 上午9:25
 * @Since version-1.0
 * @青软实训
 */

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired(required = false)
    private CartService cartService;
    @Autowired(required = false)
    private OrderService orderService;

    @RequestMapping("/order-cart")
    public String showOrderCart(Model model, HttpServletRequest request) {
        //取购物车商品列表
        List<CartItem> list = cartService.getCartItems(request);
        model.addAttribute("cartList", list);

        return "order-cart";
    }
/**
 * @Author Xiang Li
 * @Date 2021/9/7 上午10:04
 * @Since version-1.0
 * @青软实训
 */

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createOrder(OrderInfo orderInfo, Model model, HttpServletRequest request) {
        // 获取用户信息
        TbUser user = (TbUser) request.getAttribute("user");
        // 补全orderIn的属性
        //设置一个定值吧先
        //
        orderInfo.setUserId((long) 37);
        orderInfo.setBuyerNick("lixiang666");
        // 调用服务

        String orderId = orderService.createOrder(orderInfo);
        model.addAttribute("orderId", orderId);
        model.addAttribute("payment", orderInfo.getPayment());
        DateTime dateTime = new DateTime();
        dateTime = dateTime.plus(3);
        model.addAttribute("date", dateTime.toString("yyyy-MM-dd"));

        return "success";
    }
}
