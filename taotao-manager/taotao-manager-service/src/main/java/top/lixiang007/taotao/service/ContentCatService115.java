package top.lixiang007.taotao.service;


import top.lixiang007.taotao.common.pojo.EasyUITreeNode115;
import top.lixiang007.taotao.common.pojo.TaotaoResult;

import java.util.List;

/**
 * @Author Xiang Li
 * @Date 2021/8/31 上午9:01
 * @Since version-1.0
 * @青软实训 内容分类服务
 */

public interface ContentCatService115 {

    List<EasyUITreeNode115> getContentCatList(Long parentId);
    TaotaoResult insertCategory(Long parentId, String name);
}
