package top.lixiang007.taotao.portal.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.lixiang007.taotao.pojo.TbItem;
import top.lixiang007.taotao.portal.service.ItemService115;


/**
 * @Author Xiang Li
 * @Date 2021/9/2 下午4:37
 * @Since version-1.0
 * @青软实训  查询商品详细信息 既搜索商品后点击跳转的详细信息页
 */

@Controller
@RequestMapping("/item")
public class ItemController115 {

    @Autowired(required = false)
    private ItemService115 itemService;
/**
 * @Author Xiang Li
 * @Date 2021/9/2 下午4:40
 * @Since version-1.0
 * @青软实训 商品基本信息展示
 */

    @RequestMapping("/{itemId}")
    public String showItemInfo(@PathVariable Long itemId, Model model) {
        TbItem tbItem = itemService.getItemById(itemId);
        model.addAttribute("item", tbItem);
        return "item";
    }
/**
 * @Author Xiang Li
 * @Date 2021/9/2 下午4:40
 * @Since version-1.0
 * @青软实训 描述
 */

    @RequestMapping(value = "/desc/{itemId}", produces = MediaType.TEXT_HTML_VALUE+";charset=utf-8")
    @ResponseBody
    public String getItemDesc(@PathVariable Long itemId) {
        return itemService.getItemDescById(itemId);
    }
/**
 * @Author Xiang Li
 * @Date 2021/9/2 下午4:41
 * @Since version-1.0
 * @青软实训 规格参数
 */

    @RequestMapping(value = "/param/{itemId}", produces = MediaType.TEXT_HTML_VALUE+";charset=utf-8")
    @ResponseBody
    public String getItemParam(@PathVariable Long itemId) {
        return itemService.getItemParamById(itemId);
    }
}
