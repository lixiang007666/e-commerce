package top.lixiang007.taotao.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import top.lixiang007.taotao.common.pojo.EasyUITreeNode115;
import top.lixiang007.taotao.common.pojo.TaotaoResult;
import top.lixiang007.taotao.service.ContentCatService115;

import java.util.List;

/**
 * 内容分类管理Controller
 */
/**
 * @Author Xiang Li
 * @Date 2021/8/31 上午9:05
 * @Since version-1.0
 * @青软实训
 */

@Controller
@RequestMapping("/content/category")
public class ContentCatController115 {

    @Autowired(required = false)
    private ContentCatService115 contentCatService115;

    @ResponseBody
    @RequestMapping("/list")
    public List<EasyUITreeNode115> getContentCatList(@RequestParam(value = "id", defaultValue = "0") Long parentId) {
        return contentCatService115.getContentCatList(parentId);
    }

    @ResponseBody
    @RequestMapping("/create")
    public TaotaoResult insertCategory(Long parentId, String name) {
        return contentCatService115.insertCategory(parentId, name);
    }
}
