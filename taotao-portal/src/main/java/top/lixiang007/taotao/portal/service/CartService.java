package top.lixiang007.taotao.portal.service;



import top.lixiang007.taotao.common.pojo.TaotaoResult;
import top.lixiang007.taotao.portal.pojo.CartItem;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
/**
 * @Author Xiang Li
 * @Date 2021/9/6 上午9:46
 * @Since version-1.0
 * @青软实训
 */

public interface CartService {
    TaotaoResult addCart(Long itemId, Integer num, HttpServletRequest request, HttpServletResponse response);

    List<CartItem> getCartItems(HttpServletRequest request);

    TaotaoResult updateCartItem(Long itemId, Integer num, HttpServletRequest request, HttpServletResponse response);

    TaotaoResult deleteCartItem(Long itemId, HttpServletRequest request, HttpServletResponse response);
}
