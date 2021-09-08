package top.lixiang007.taotao.portal.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import top.lixiang007.taotao.pojo.TbUser;
import top.lixiang007.taotao.portal.pojo.CartItem;
import top.lixiang007.taotao.portal.pojo.OrderInfo;
import top.lixiang007.taotao.portal.service.CartService;
import top.lixiang007.taotao.portal.service.OrderService;
/**
 * @Author Xiang Li
 * @Date 2021/9/7 下午9:07
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
    public String showOrderCart(HttpServletRequest request, HttpServletResponse response, Model model) {
        //取购物车商品列表
        List<CartItem> list = cartService.getCartItems(request);
        //传递给页面
        model.addAttribute("cartList", list);

        return "order-cart";
    }

    @RequestMapping("/create")
    public String createOrder(OrderInfo order, Model model, HttpServletRequest request) {
        try {
            //从Request中取用户信息
            TbUser user = (TbUser) request.getAttribute("user");
            //在order对象中补全用户信息
            order.setUserId((long) 37);
            order.setBuyerNick("lixiang666");
            //调用服务
            String orderId = orderService.createOrder(order);
            model.addAttribute("orderId", orderId);
            model.addAttribute("payment", order.getPayment());
            model.addAttribute("date", new DateTime().plusDays(3).toString("yyyy-MM-dd"));
            return "success";

        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("message", "创建订单出错。请稍后重试！");
            return "error/exception";
        }
    }

}
