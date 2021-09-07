package top.lixiang007.taotao.portal.service.impl;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import top.lixiang007.taotao.common.pojo.TaotaoResult;
import top.lixiang007.taotao.common.utils.HttpClientUtil;
import top.lixiang007.taotao.common.utils.JsonUtils;
import top.lixiang007.taotao.portal.pojo.OrderInfo;
import top.lixiang007.taotao.portal.service.OrderService;
/**
 * @Author Xiang Li
 * @Date 2021/9/7 上午9:27
 * @Since version-1.0
 * @青软实训
 */

@Service
public class OrderServiceImpl implements OrderService {

    @Value("${ORDER_BASE_URL}")
    private String ORDER_BASE_URL;
    @Value("${ORDER_CREATE_URL}")
    private String ORDER_CREATE_URL;

    /**
     * 前端创建订单服务
     * @param orderInfo
     * @return
     */
    /**
     * @Author Xiang Li
     * @Date 2021/9/7 上午10:02
     * @Since version-1.0
     * @青软实训
     */
    
    @Override
    public String createOrder(OrderInfo orderInfo) {
        String paramJson = JsonUtils.objectToJson(orderInfo);
        String resultJson = HttpClientUtil.doPostJson(ORDER_BASE_URL + ORDER_CREATE_URL, paramJson);
        // 转换成TaotaoResult对象
        TaotaoResult taotaoResult = TaotaoResult.format(resultJson);
        // 取得订单号
        //assert taotaoResult != null;
        assert taotaoResult != null;
        return taotaoResult.getData().toString();
    }
}
