package top.lixiang007.taotao.portal.service;


import top.lixiang007.taotao.portal.pojo.SearchResult;
/**
 * @Author Xiang Li
 * @Date 2021/9/2 上午10:42
 * @Since version-1.0
 * @青软实训
 */

public interface SearchService {
    SearchResult search(String keyword, int page, int rows);
}
