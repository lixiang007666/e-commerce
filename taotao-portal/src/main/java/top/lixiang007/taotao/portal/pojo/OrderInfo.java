package top.lixiang007.taotao.portal.pojo;


import top.lixiang007.taotao.pojo.TbOrder;
import top.lixiang007.taotao.pojo.TbOrderItem;
import top.lixiang007.taotao.pojo.TbOrderShipping;

import java.util.List;
/**
 * @Author Xiang Li
 * @Date 2021/9/7 上午9:24
 * @Since version-1.0
 * @青软实训
 */

public class OrderInfo extends TbOrder {
    private List<TbOrderItem> orderItems;
    private TbOrderShipping orderShipping;

    public List<TbOrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<TbOrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public TbOrderShipping getOrderShipping() {
        return orderShipping;
    }

    public void setOrderShipping(TbOrderShipping orderShipping) {
        this.orderShipping = orderShipping;
    }
}
