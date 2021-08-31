package top.lixiang007.taotao.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.lixiang007.taotao.common.pojo.EasyUITreeNode115;
import top.lixiang007.taotao.common.pojo.TaotaoResult;
import top.lixiang007.taotao.mapper.TbContentCategoryMapper;
import top.lixiang007.taotao.pojo.TbContentCategory;
import top.lixiang007.taotao.service.ContentCatService115;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 内容分类管理Service
 */
/**
 * @Author Xiang Li
 * @Date 2021/8/31 上午9:03
 * @Since version-1.0
 * @青软实训
 */

@Service
public class ContentCatServiceImpl115 implements ContentCatService115 {

    @Autowired(required = false)
    private TbContentCategoryMapper tbContentCategoryMapper;

    @Override
    public List<EasyUITreeNode115> getContentCatList(Long parentId) {
        List<TbContentCategory> categories = tbContentCategoryMapper.selectTbContentCatsByParentId(parentId);
        List<EasyUITreeNode115> nodes = new ArrayList<>();

        for (TbContentCategory contentCategory : categories) {
            EasyUITreeNode115 node = new EasyUITreeNode115();
            node.setId(contentCategory.getId());
            node.setText(contentCategory.getName());
            node.setState(contentCategory.getIsParent() ? "closed" : "open");
            nodes.add(node);
        }
        return nodes;
    }
/**
 * @Author Xiang Li
 * @Date 2021/8/31 上午9:18
 * @Since version-1.0
 * @青软实训 添加了 "内容分类节点添加Test-李响" 节点
 */

    @Override
    public TaotaoResult insertCategory(Long parentId, String name) {
        TbContentCategory contentCategory = new TbContentCategory();
        contentCategory.setName(name);
        contentCategory.setParentId(parentId);
        contentCategory.setIsParent(false);
        contentCategory.setStatus(1);  // 1正常 2删除
        contentCategory.setSortOrder(1);
        contentCategory.setCreated(new Date());
        contentCategory.setUpdated(new Date());
        tbContentCategoryMapper.insertCategory(contentCategory);

        TbContentCategory parentContentCategory = tbContentCategoryMapper.selectTbContentCatById(parentId);
        if (!parentContentCategory.getIsParent()) {
            parentContentCategory.setIsParent(true);
            parentContentCategory.setUpdated(new Date());
            tbContentCategoryMapper.updateContentCategoryById(parentContentCategory);
        }
        return TaotaoResult.ok(contentCategory.getId());
    }
}
