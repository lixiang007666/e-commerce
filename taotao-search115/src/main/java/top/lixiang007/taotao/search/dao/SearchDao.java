package top.lixiang007.taotao.search.dao;


import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import top.lixiang007.taotao.search.pojo.SearchResult;

/**
 * @Author Xiang Li
 * @Date 2021/9/2 上午10:16
 * @Since version-1.0
 * @青软实训
 */

public interface SearchDao {
    SearchResult search(SolrQuery solrQuery) throws SolrServerException;
}
