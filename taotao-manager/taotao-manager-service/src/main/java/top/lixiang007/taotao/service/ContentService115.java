package top.lixiang007.taotao.service;


import top.lixiang007.taotao.common.pojo.EasyUIDataGridResult;
import top.lixiang007.taotao.common.pojo.TaotaoResult;
import top.lixiang007.taotao.pojo.TbContent;

/**
 * @Author Xiang Li
 * @Date 2021/8/31 上午9:37
 * @Since version-1.0
 * @青软实训 内容管理service
 */

public interface ContentService115 {
    EasyUIDataGridResult getContentListByCategoryId(Long categoryId, int page, int rows);
    /**
     * @Author Xiang Li
     * @Date 2021/8/31 上午9:38
     * @Since version-1.0
     * @青软实训 插入一条内容 如插入一个大广告
     */

    TaotaoResult insertContent(TbContent tbContent);
}
