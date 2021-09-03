package top.lixiang007.taotao.sso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 登录注册页面
 */
/**
 * @Author Xiang Li
 * @Date 2021/9/3 上午9:57
 * @Since version-1.0
 * @青软实训 点击jsp登录或注册按钮要跳转的url designed by 李响
 */

@Controller
@RequestMapping("/page")
public class PageController115 {

    @RequestMapping("/login")
    public String showLogin(String redirectUrl, Model model) {
        model.addAttribute("redirect", redirectUrl);
        return "login";
    }

    @RequestMapping("/register")
    public String shoRegist() {
        return "register";
    }
}
