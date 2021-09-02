package top.lixiang007.taotao.rest.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.lixiang007.taotao.common.pojo.TaotaoResult;
import top.lixiang007.taotao.common.utils.ExceptionUtil;
import top.lixiang007.taotao.rest.service.ItemService115;
/**
 * @Author Xiang Li
 * @Date 2021/9/2 上午11:34
 * @Since version-1.0
 * @青软实训   点击商品图像 跳转详情的一部分实现
 */

@Controller
@RequestMapping("/item")
public class ItemController115 {

    @Autowired(required = false)
    private ItemService115 itemService;

    /**
     * 获取商品基本信息
     * @param itemId
     * @return
     */
    @RequestMapping("/base/{itemId}")
    @ResponseBody
    public TaotaoResult getItemById(@PathVariable Long itemId) {
        try {
            return TaotaoResult.ok(itemService.getItemById(itemId));
        } catch (Exception e) {
            e.printStackTrace();
            return TaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
        }
    }

    /**
     * 获取商品详情
     * @param itemId
     * @return
     */
    @RequestMapping("/desc/{itemId}")
    @ResponseBody
    public TaotaoResult getItemDescById(@PathVariable Long itemId) {
        try {
            return TaotaoResult.ok(itemService.getItemDescById(itemId));
        } catch (Exception e) {
            e.printStackTrace();
            return TaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
        }
    }

    /**
     * 获取商品参数
     * @param itemId
     * @return
     */
    @RequestMapping("/param/{itemId}")
    @ResponseBody
    public TaotaoResult getItemParamById(@PathVariable Long itemId) {
        try {
            return TaotaoResult.ok(itemService.getItemParamById(itemId));
        } catch (Exception e) {
            e.printStackTrace();
            return TaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
        }
    }
}
