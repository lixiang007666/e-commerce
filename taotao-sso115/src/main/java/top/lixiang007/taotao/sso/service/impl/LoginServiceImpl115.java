package top.lixiang007.taotao.sso.service.impl;


import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import top.lixiang007.taotao.common.pojo.TaotaoResult;
import top.lixiang007.taotao.common.utils.CookieUtils;
import top.lixiang007.taotao.common.utils.JsonUtils;
import top.lixiang007.taotao.mapper.TbUserMapper;
import top.lixiang007.taotao.pojo.TbUser;

import top.lixiang007.taotao.sso.component.JedisClient;
import top.lixiang007.taotao.sso.service.LoginService115;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @Author Xiang Li
 * @Date 2021/9/3 上午9:51
 * @Since version-1.0
 * @青软实训
 */

@Service
public class LoginServiceImpl115 implements LoginService115 {

    @Autowired(required = false)
    private TbUserMapper userMapper;
    @Autowired
    private JedisClient jedisClient;
    @Value("${REDIS_SESSION_KEY}")
    private String REDIS_SESSION_KEY;
    @Value("${SESSION_EXPIRE}")
    private Integer SESSION_EXPIRE;

    /**
     * 用户登录服务
     * @param username 用户名
     * @param password 密码
     * @param request
     * @param response
     * @return
     */
    @Override
    public TaotaoResult login(String username, String password, HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("username", username);
        List<TbUser> users = userMapper.selectUserByNameOrPwd(paramMap);

        if (users == null || users.isEmpty()) {
            return TaotaoResult.build(400, "该用户不存在");
        }

        TbUser tbUser = users.get(0);
        // 校验密码
        if (!tbUser.getPassword().equals(DigestUtils.md5DigestAsHex(password.getBytes()))) {
            return TaotaoResult.build(400, "密码错误");
        }

        // 登录成功
        String token = UUID.randomUUID().toString();
        tbUser.setPassword(null);
        jedisClient.set(REDIS_SESSION_KEY + ":" + token, JsonUtils.objectToJson(tbUser));
        jedisClient.expire(REDIS_SESSION_KEY + ":" + token, SESSION_EXPIRE);

        // Token写入cookie 浏览器关闭就过期
        CookieUtils.setCookie(request, response, "TT_TOKEN", token);
        return TaotaoResult.ok(token);
    }

    /**
     * 通过token查询用户信息
     * @param token token
     * @return 用户信息  直接登录了哦 easy！
     */
    @Override
    public TaotaoResult getUserByToken(String token) {
        String json = jedisClient.get(REDIS_SESSION_KEY + ":" + token);
        if (StringUtils.isBlank(json)) {
            return TaotaoResult.build(400, "用户session已经过期");
        }
        TbUser user = JsonUtils.jsonToPojo(json, TbUser.class);
        //更新session的过期时间
        jedisClient.expire(REDIS_SESSION_KEY + ":" + token, SESSION_EXPIRE);
        return TaotaoResult.ok(user);
    }

    /**
     * 退出登录
     * @param token
     * @return
     */
    @Override
    public TaotaoResult logout(String token, HttpServletRequest request, HttpServletResponse response) {
        Long result = jedisClient.del(REDIS_SESSION_KEY + ":" + token);
        CookieUtils.deleteCookie(request, response, "TT_TOKEN");
        if (result > 0) {
            return TaotaoResult.ok("退出成功");
        } else {
            return TaotaoResult.ok("用户未登录");
        }
    }
}
