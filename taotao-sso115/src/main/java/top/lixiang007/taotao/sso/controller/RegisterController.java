package top.lixiang007.taotao.sso.controller;


import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import top.lixiang007.taotao.common.pojo.TaotaoResult;
import top.lixiang007.taotao.common.utils.ExceptionUtil;
import top.lixiang007.taotao.pojo.TbUser;
import top.lixiang007.taotao.sso.service.RegisterService115;

/**
 * 用户注册
 */
/**
 * @Author Xiang Li
 * @Date 2021/9/3 上午9:43
 * @Since version-1.0
 * @青软实训
 */

@Controller
@RequestMapping("/user")
public class RegisterController {

    @Autowired(required = false)
    private RegisterService115 registerService;

    /**
     * 数据校验接口
     * @param param 参数
     * @param type 校验参数类型
     * @param callback jsonp的回调函数名称
     * @return
     */
    @RequestMapping("/check/{param}/{type}")
    @ResponseBody
    public Object checkData(@PathVariable String param, @PathVariable Integer type, String callback) {
        try {
            TaotaoResult result = registerService.checkData(param, type);
            if (StringUtils.isNotBlank(callback)) {
                MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(result);
                mappingJacksonValue.setJsonpFunction(callback);
                return mappingJacksonValue;
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return TaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
        }
    }


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public TaotaoResult register(TbUser user) {
        try {
            TaotaoResult result = registerService.register(user);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return TaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
        }
    }
}
