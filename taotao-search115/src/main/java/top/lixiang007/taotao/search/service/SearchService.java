package top.lixiang007.taotao.search.service;


import org.apache.solr.client.solrj.SolrServerException;
import top.lixiang007.taotao.search.pojo.SearchResult;

/**
 * @Author Xiang Li
 * @Date 2021/9/2 上午10:17
 * @Since version-1.0
 * @青软实训
 */

public interface SearchService {
    SearchResult search(String queryString, int page, int rows) throws SolrServerException;
}
