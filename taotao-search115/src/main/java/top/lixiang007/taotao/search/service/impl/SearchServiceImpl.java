package top.lixiang007.taotao.search.service.impl;


import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.lixiang007.taotao.search.dao.SearchDao;
import top.lixiang007.taotao.search.pojo.SearchResult;
import top.lixiang007.taotao.search.service.SearchService;

/**
 * Solr查询服务
 */
/**
 * @Author Xiang Li
 * @Date 2021/9/2 上午10:41
 * @Since version-1.0
 * @青软实训
 */

@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private SearchDao searchDao;

    @Override
    public SearchResult search(String queryString, int page, int rows) throws SolrServerException {
        // 创建查询条件
        SolrQuery solrQuery = new SolrQuery();
        solrQuery.setQuery(queryString);

        solrQuery.setStart((page - 1) * rows);
        solrQuery.setRows(rows);
        // 设置默认搜索域
        solrQuery.set("df", "item_title");

        solrQuery.setHighlight(true);
        solrQuery.addHighlightField("item_title");
        solrQuery.setHighlightSimplePre("<font class=\"skcolor_ljg\">");
        solrQuery.setHighlightSimplePost("</font>");

        // 执行查询
        SearchResult searchResult = searchDao.search(solrQuery);
        Long recordCount = searchResult.getRecordCount();
        int pageCount = (int) (recordCount / rows);
        if (recordCount % rows > 0) {
            pageCount++;
        }
        searchResult.setPageCount(pageCount);
        searchResult.setCurrentPage(page);
        return searchResult;

    }
}
