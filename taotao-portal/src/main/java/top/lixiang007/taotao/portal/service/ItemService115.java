package top.lixiang007.taotao.portal.service;


import top.lixiang007.taotao.pojo.TbItem;
/**
 * @Author Xiang Li
 * @Date 2021/9/2 下午4:41
 * @Since version-1.0
 * @青软实训
 */

public interface ItemService115 {
    TbItem getItemById(Long itemId);
    String getItemDescById(Long itemId);
    String getItemParamById(Long itemId);
}
