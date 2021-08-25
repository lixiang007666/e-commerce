package top.lixiang007.taotao.service.impl;


import top.lixiang007.taotao.common.pojo.EasyUITreeNode115;
import top.lixiang007.taotao.mapper.TbItemCatMapper;
import top.lixiang007.taotao.pojo.TbItemCat;
import top.lixiang007.taotao.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemCatServiceImpl implements ItemCatService {

    @Autowired(required = false)
    private TbItemCatMapper tbItemCatMapper;

    @Override
    public List<EasyUITreeNode115> getItemCatList(long parentId) {
        List<EasyUITreeNode115> result = new ArrayList<>();
        List<TbItemCat> itemCatList = tbItemCatMapper.getItemCatByParentId(parentId);

        for (TbItemCat tbItemCat : itemCatList) {
            EasyUITreeNode115 easyUITreeNode = new EasyUITreeNode115();
            easyUITreeNode.setId(tbItemCat.getId());
            easyUITreeNode.setState(tbItemCat.getIsParent() ? "closed" : "opened");
            easyUITreeNode.setText(tbItemCat.getName());
            result.add(easyUITreeNode);
        }
        return result;
    }
}
