package top.lixiang007.taotao.portal.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.lixiang007.taotao.common.pojo.TaotaoResult;
import top.lixiang007.taotao.portal.pojo.CartItem;
import top.lixiang007.taotao.portal.service.CartService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 购物车Controller
 */
/**
 * @Author Xiang Li
 * @Date 2021/9/6 上午9:35
 * @Since version-1.0
 * @青软实训 不登录也可以访问购物车 添加购物车信息存储到cookie中后 用户进行登录既可以看到购物车信息
 */

@Controller
@RequestMapping("/cart")
public class CartController115 {

    @Autowired(required = false)
    private CartService cartService;

    @RequestMapping("/add/{itemId}")
    public String addCart(@PathVariable Long itemId, Integer num, HttpServletRequest request, HttpServletResponse response) {
        TaotaoResult result = cartService.addCart(itemId, num, request, response);
        return "cart-success";
    }

    @RequestMapping("/cart")
    public String showCart(Model model, HttpServletRequest request) {
        List<CartItem> cartItems = cartService.getCartItems(request);
        model.addAttribute("cartList", cartItems);
        return "cart";
    }

    @RequestMapping("/update/num/{itemId}/{num}")
    @ResponseBody
    public TaotaoResult updateCartItemNum(@PathVariable Long itemId, @PathVariable Integer num, HttpServletResponse response, HttpServletRequest request) {
        return cartService.updateCartItem(itemId, num, request, response);
    }

    @RequestMapping("/delete/{itemId}")
    public String deleteCartItem(@PathVariable Long itemId, HttpServletResponse response, HttpServletRequest request) {
        TaotaoResult result = cartService.deleteCartItem(itemId, request, response);
        return "redirect:/cart/cart.html";
    }
}
