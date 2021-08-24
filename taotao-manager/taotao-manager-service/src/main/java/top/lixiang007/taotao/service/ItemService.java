package top.lixiang007.taotao.service;




import top.lixiang007.taotao.common.pojo.EasyUIDataGridResult;
import top.lixiang007.taotao.common.pojo.TaotaoResult;
import top.lixiang007.taotao.pojo.TbItem;

/**
 * 商品查询service
 */
/**
 * @Author Xiang Li
 * @Date 2021/8/24 下午12:33
 * @Since version-1.0
 * @青软实训
 */

public interface ItemService {
    TbItem getItemById(Long id);

    EasyUIDataGridResult getItemList(int page, int rows);

    TaotaoResult createItem(TbItem item, String desc, String itemParam);
}
