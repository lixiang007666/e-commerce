package top.lixiang007.taotao.rest.service;


import top.lixiang007.taotao.pojo.TbItem;
import top.lixiang007.taotao.pojo.TbItemDesc;
import top.lixiang007.taotao.pojo.TbItemParamItem;

/**
 * @Author Xiang Li
 * @Date 2021/9/2 上午11:20
 * @Since version-1.0
 * @青软实训 点击商品 跳转查看商品信息
 */

public interface ItemService115 {
/**
 * @Author Xiang Li
 * @Date 2021/9/2 上午11:20
 * @Since version-1.0
 * @青软实训 根据id查询
 */

TbItem getItemById(Long itemId);

	TbItemDesc getItemDescById(Long itemId);

	TbItemParamItem getItemParamById(Long itemId);
}
