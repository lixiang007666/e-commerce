package top.lixiang007.taotao.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import top.lixiang007.taotao.common.pojo.EasyUITreeNode115;
import top.lixiang007.taotao.service.ItemCatService;

import java.util.List;
/**
 * @Author Xiang Li
 * @Date 2021/8/25 上午9:31
 * @Since version-1.0
 * @青软实训
 */

@Controller
@RequestMapping("/item/cat")
public class ItemCatController {

    @Autowired
    private ItemCatService itemCatService;

    @RequestMapping("/list")
    @ResponseBody
    public List<EasyUITreeNode115> getItemCatList(@RequestParam(value = "id", defaultValue = "0") Long parentId) {
        return itemCatService.getItemCatList(parentId);
    }
}
