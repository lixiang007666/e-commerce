package top.lixiang007.taotao.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.lixiang007.taotao.common.pojo.EasyUIDataGridResult;
import top.lixiang007.taotao.common.pojo.TaotaoResult;
import top.lixiang007.taotao.service.ItemParamService;
/**
 * @Author Xiang Li
 * @Date 2021/8/26 上午10:54
 * @Since version-1.0
 * @青软实训  查询RequestMapping的值可以找到js或JSP
 */

@Controller
@RequestMapping("/item/param")
public class ItemParamController115 {

    @Autowired
    private ItemParamService itemParamService;

    @RequestMapping("/list")
    @ResponseBody
    public EasyUIDataGridResult getItemParamList(Integer page, Integer rows) {
        return itemParamService.getItemParamList(page, rows);
    }

    @RequestMapping("/query/itemcatid/{cid}")
    @ResponseBody
    public TaotaoResult getItemParamByCid(@PathVariable Long cid) {
        return itemParamService.getItemParamByCid(cid);
    }

    @RequestMapping("/save/{cid}")
    @ResponseBody
    public TaotaoResult insertItemParam(@PathVariable Long cid, String paramData) {
        return itemParamService.insertItemParam(cid, paramData);
    }
}
