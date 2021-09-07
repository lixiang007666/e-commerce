package top.lixiang007.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import top.lixiang007.taotao.common.pojo.TaotaoResult;
import top.lixiang007.taotao.pojo.TbItem;
import top.lixiang007.taotao.service.ItemManangeService115;

/**
 * @Author Xiang Li
 * @Date 2021/9/7 下午12:05
 * @Since version-1.0
 * @青软实训
 */
@Controller
public class ItemManangeController115 {

    @Autowired(required = false)
    private ItemManangeService115 itemManangeService115;
    //上架商品
    @RequestMapping(value="/item/reshelf",method=RequestMethod.POST)
    @ResponseBody
    private TaotaoResult reshelfItem(@RequestParam("ids") long itemId, TbItem item) {
        TaotaoResult result=itemManangeService115.reshelfItem(itemId, item);
        return result;
    }



    // 下架商品
    @RequestMapping(value="/item/instock",method=RequestMethod.POST)
    @ResponseBody
    private TaotaoResult instockItem(@RequestParam("ids") long itemId, TbItem item) {
        TaotaoResult result=itemManangeService115.instockItem(itemId, item);
        return result;
    }

}
