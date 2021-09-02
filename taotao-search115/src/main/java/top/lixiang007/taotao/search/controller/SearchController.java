package top.lixiang007.taotao.search.controller;


import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import top.lixiang007.taotao.common.pojo.TaotaoResult;
import top.lixiang007.taotao.common.utils.ExceptionUtil;
import top.lixiang007.taotao.search.pojo.SearchResult;
import top.lixiang007.taotao.search.service.SearchService;

import java.io.UnsupportedEncodingException;

/**
 * Slor搜索Controller
 */
/**
 * @Author Xiang Li
 * @Date 2021/9/2 上午10:15
 * @Since version-1.0
 * @青软实训
 */

@Controller
public class SearchController {

    @Autowired(required = false)
    private SearchService searchService;

    @RequestMapping("/q")
    @ResponseBody
    public TaotaoResult search(@RequestParam(defaultValue = "") String keyword,
                               @RequestParam(defaultValue = "1") Integer page,
                               @RequestParam(defaultValue = "30") Integer rows) {

        try {
            keyword = new String(keyword.getBytes("iso8859-1"), "utf-8");
            SearchResult result = searchService.search(keyword, page, rows);
            return TaotaoResult.ok(result);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return TaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
        } catch (SolrServerException e) {
            e.printStackTrace();
            return TaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
        }
    }
}
