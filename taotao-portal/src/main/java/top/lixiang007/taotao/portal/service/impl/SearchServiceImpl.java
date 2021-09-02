package top.lixiang007.taotao.portal.service.impl;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import top.lixiang007.taotao.common.pojo.TaotaoResult;
import top.lixiang007.taotao.common.utils.HttpClientUtil;
import top.lixiang007.taotao.portal.pojo.SearchResult;
import top.lixiang007.taotao.portal.service.SearchService;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Xiang Li
 * @Date 2021/9/2 上午10:38
 * @Since version-1.0
 * @青软实训
 */

@Service
public class SearchServiceImpl implements SearchService {

    @Value("${SEARCH_BASE_URL}")
    private String SEARCH_BASE_URL;

    @Override
    public SearchResult search(String keyword, int page, int rows) {
        // 调用服务查询数据
        Map<String, String> params = new HashMap<>();
        params.put("keyword", keyword);
        params.put("page", page+"");
        params.put("rows", rows+"");
        String json = HttpClientUtil.doGet(SEARCH_BASE_URL, params);
        TaotaoResult taotaoResult = TaotaoResult.formatToPojo(json, SearchResult.class);

        return (SearchResult) taotaoResult.getData();
    }
}
