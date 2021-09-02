package top.lixiang007.taotao.search.service;


import org.apache.solr.client.solrj.SolrServerException;
import top.lixiang007.taotao.common.pojo.TaotaoResult;

import java.io.IOException;

/**
 * @Author Xiang Li
 * @Date 2021/9/2 上午9:37
 * @Since version-1.0
 * @青软实训
 */

public interface ItemService {
    TaotaoResult importItems() throws IOException, SolrServerException;
}
