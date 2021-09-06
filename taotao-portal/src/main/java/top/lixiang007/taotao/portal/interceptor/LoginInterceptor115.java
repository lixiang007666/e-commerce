package top.lixiang007.taotao.portal.interceptor;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import top.lixiang007.taotao.pojo.TbUser;
import top.lixiang007.taotao.portal.service.UserService115;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用户登录拦截器
 */

/**
 * @Author Xiang Li
 * @Date 2021/9/6 上午8:53
 * @Since version-1.0
 * @青软实训 当访问一个商品界面时 没有登录会跳转到登录界面 登录后继续访问
 */

public class LoginInterceptor115 implements HandlerInterceptor {

    @Autowired
    private UserService115 userService;
    @Value("${SSO_LOGIN_URL}")
    private String SSO_LOGIN_URL;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        TbUser user = userService.getUserByToken(httpServletRequest, httpServletResponse);
        // 如果用户处于未登录状态，跳转到登录页面
        if (user == null) {
            httpServletResponse.sendRedirect(SSO_LOGIN_URL + "?redirectUrl=" + httpServletRequest.getRequestURL());
            return false;
        }
        /**
         * @Author Xiang Li
         * @Date 2021/9/6 上午9:48
         * @Since version-1.0
         * @青软实训  UserServiceImpl115里面取cookie的tocken了
         */

        // 如果取到用户信息，放行
        httpServletRequest.setAttribute("user", user);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
