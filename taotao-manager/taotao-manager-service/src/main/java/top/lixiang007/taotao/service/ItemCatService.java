package top.lixiang007.taotao.service;

/**
 * @Author Xiang Li
 * @Date 2021/8/25 上午9:20
 * @Since version-1.0
 * @青软实训
 */


import top.lixiang007.taotao.common.pojo.EasyUITreeNode115;

import java.util.List;

public interface ItemCatService {

    List<EasyUITreeNode115> getItemCatList(long parentId);
}
