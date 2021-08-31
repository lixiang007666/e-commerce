package top.lixiang007.taotao.portal.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import top.lixiang007.taotao.portal.service.ContentService;

/**
 * 首页显示
 */
/**
 * @Author Xiang Li
 * @Date 2021/8/31 上午10:30
 * @Since version-1.0
 * @青软实训 大广告的参数设置放在service里面了 designed by lixiang
 */

@Controller
public class IndexController {

    @Autowired(required = false)
    private ContentService contentService;

    @RequestMapping("/index")
    public String showIndex(Model model) {
        String json = contentService.getAdList();
        model.addAttribute("ad1", json);
        return "index";
    }

}
