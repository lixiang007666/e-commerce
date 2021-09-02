package top.lixiang007.taotao.search.service.impl;


import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.lixiang007.taotao.common.pojo.TaotaoResult;
import top.lixiang007.taotao.search.mapper.ItemMapper;
import top.lixiang007.taotao.search.pojo.SearchItem;
import top.lixiang007.taotao.search.service.ItemService;

import java.io.IOException;
import java.util.List;

/**
 * @Author Xiang Li
 * @Date 2021/9/2 上午9:36
 * @Since version-1.0
 * @青软实训 导入商品service
 */

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private SolrServer solrServer;
    @Autowired(required = false)
    private ItemMapper itemMapper;

    /**
     * 导入商品信息
     * @return
     */
    @Override
    public TaotaoResult importItems() throws IOException, SolrServerException {
        // 查询数据库获取商品列表
        List<SearchItem> itemList = itemMapper.getItemList();
        // 遍历列表创建文档对象
        for (SearchItem searchItem : itemList) {
            SolrInputDocument document = new SolrInputDocument();
            document.addField("id", searchItem.getId());
            document.addField("item_title", searchItem.getTitle());
            document.addField("item_sell_point", searchItem.getSellPoint());
            document.addField("item_price", searchItem.getPrice());
            document.addField("item_image", searchItem.getImage());
            document.addField("item_category_name", searchItem.getCategoryName());
            document.addField("item_desc", searchItem.getItemDesc());

            solrServer.add(document);
        }

        solrServer.commit();
        return TaotaoResult.ok();
    }
}
