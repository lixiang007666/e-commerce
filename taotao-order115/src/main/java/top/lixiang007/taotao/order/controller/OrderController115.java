package top.lixiang007.taotao.order.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import top.lixiang007.taotao.common.pojo.TaotaoResult;
import top.lixiang007.taotao.common.utils.ExceptionUtil;
import top.lixiang007.taotao.order.pojo.OrderInfo;
import top.lixiang007.taotao.order.service.OrderService115;
/**
 * @Author Xiang Li
 * @Date 2021/9/7 上午9:24
 * @Since version-1.0
 * @青软实训
 */

@Controller
@RequestMapping("/order")
public class OrderController115 {

    @Autowired(required = false)
    private OrderService115 orderService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public TaotaoResult createOrder(@RequestBody OrderInfo orderInfo) {
        try {
            return orderService.createOrder(orderInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return TaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
        }
    }
}
