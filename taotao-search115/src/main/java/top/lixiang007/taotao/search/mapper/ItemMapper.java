package top.lixiang007.taotao.search.mapper;



import top.lixiang007.taotao.search.pojo.SearchItem;

import java.util.List;

/**
 * Solr服务的导入数据
 */
/**
 * @Author Xiang Li
 * @Date 2021/9/2 上午9:37
 * @Since version-1.0
 * @青软实训
 */

public interface ItemMapper {

    List<SearchItem> getItemList();
}
