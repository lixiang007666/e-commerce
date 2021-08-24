package top.lixiang007.taotao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 展示首页
 */
@Controller
public class PageController115 {
    /**
     * @Author Xiang Li
     * @Date 2021/8/24 上午10:31
     * @Since version-1.0
     * @青软实训
     */
    @RequestMapping("/")
    public String showIndex() {
        return "index";
    }

    @RequestMapping("/{page}")
    public String showPage(@PathVariable String page) {
        return page;
    }
}
