package top.lixiang007.taotao.portal.service;



import top.lixiang007.taotao.pojo.TbUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @Author Xiang Li
 * @Date 2021/9/6 上午8:52
 * @Since version-1.0
 * @青软实训 用户登录Service 拦截器使用了
 */


public interface UserService115 {
    TbUser getUserByToken(HttpServletRequest request, HttpServletResponse response);
}
