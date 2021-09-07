package top.lixiang007.taotao.portal.service;


import top.lixiang007.taotao.common.pojo.TaotaoResult;
import top.lixiang007.taotao.portal.pojo.OrderInfo;
/**
 * @Author Xiang Li
 * @Date 2021/9/7 上午9:26
 * @Since version-1.0
 * @青软实训
 */

public interface OrderService {
    String createOrder(OrderInfo orderInfo);
}
