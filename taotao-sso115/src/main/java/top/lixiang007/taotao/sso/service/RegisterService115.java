package top.lixiang007.taotao.sso.service;


import top.lixiang007.taotao.common.pojo.TaotaoResult;
import top.lixiang007.taotao.pojo.TbUser;

/**
 * @Author Xiang Li
 * @Date 2021/9/3 上午9:39
 * @Since version-1.0
 * @青软实训
 */

public interface RegisterService115 {
    /**
     * @Author Xiang Li
     * @Date 2021/9/3 上午9:39
     * @Since version-1.0
     * @青软实训 数据校验方法
     */
    
    TaotaoResult checkData(String param, int type);

    TaotaoResult register(TbUser user);
}
