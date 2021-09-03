package top.lixiang007.taotao.sso.service;



import top.lixiang007.taotao.common.pojo.TaotaoResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * @Author Xiang Li
 * @Date 2021/9/3 上午9:49
 * @Since version-1.0
 * @青软实训
 */

public interface LoginService115 {
    TaotaoResult login(String username, String password, HttpServletRequest request, HttpServletResponse response);

    TaotaoResult getUserByToken(String token);

    TaotaoResult logout(String token, HttpServletRequest request, HttpServletResponse response);
}
