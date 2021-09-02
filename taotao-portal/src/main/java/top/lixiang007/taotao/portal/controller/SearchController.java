package top.lixiang007.taotao.portal.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.lixiang007.taotao.portal.pojo.SearchResult;
import top.lixiang007.taotao.portal.service.SearchService;

import java.io.UnsupportedEncodingException;

/**
 * 前端搜索实现
 */
/**
 * @Author Xiang Li
 * @Date 2021/9/2 上午10:42
 * @Since version-1.0
 * @青软实训
 */

@Controller
public class SearchController {

    @Autowired(required = false)
    private SearchService searchService;

    @RequestMapping("/search")
    public String search(@RequestParam("q") String keyword,
                         @RequestParam(defaultValue = "1") Integer page,
                         @RequestParam(defaultValue = "60") Integer rows,
                         Model model) {
        //get乱码处理
        try {
            keyword = new String(keyword.getBytes("iso8859-1"), "utf-8");
        } catch (UnsupportedEncodingException e) {
            keyword = "";
            e.printStackTrace();
        }
        SearchResult searchResult = searchService.search(keyword, page, rows);
        model.addAttribute("query", keyword);
        model.addAttribute("totalPages", searchResult.getPageCount());
        model.addAttribute("itemList", searchResult.getItemList());
        model.addAttribute("page", searchResult.getCurrentPage());
        return "search";
    }
}
