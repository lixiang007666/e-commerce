package top.lixiang007.taotao.search.controller;


import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.lixiang007.taotao.common.pojo.TaotaoResult;
import top.lixiang007.taotao.common.utils.ExceptionUtil;
import top.lixiang007.taotao.search.service.ItemService;

import java.io.IOException;

/**
 * 导入商品数据Controller  调用itemService
 */
/**
 * @Author Xiang Li
 * @Date 2021/9/2 上午9:43
 * @Since version-1.0
 * @青软实训
 * 需要把数据库中的商品信息导入索引库，需要商品的id、商品的名称、商品的卖点、商品的价格、商品的图片、商品的分类名称。
 * 原则：需要展示给用户的字段、需要搜索的字段需要添加到索引库。by 李响。
 * http://localhost:8083/search/import_all_items 导入数据
 */

@Controller
public class ItemController {

    @Autowired(required = false)
    private ItemService itemService;

    @RequestMapping("/import_all_items")
    @ResponseBody
    public TaotaoResult importAllItem() {
        try {
            TaotaoResult result = itemService.importItems();
            return result;
        } catch (IOException e) {
            e.printStackTrace();
            return TaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
        } catch (SolrServerException e) {
            e.printStackTrace();
            return TaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
        }
    }
}
