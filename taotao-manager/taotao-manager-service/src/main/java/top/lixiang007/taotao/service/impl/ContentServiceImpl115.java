package top.lixiang007.taotao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.lixiang007.taotao.common.pojo.EasyUIDataGridResult;
import top.lixiang007.taotao.common.pojo.TaotaoResult;
import top.lixiang007.taotao.mapper.TbContentMapper;
import top.lixiang007.taotao.pojo.TbContent;
import top.lixiang007.taotao.service.ContentService115;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author Xiang Li
 * @Date 2021/8/31 上午9:40
 * @Since version-1.0
 * @青软实训
 */


@Service
public class ContentServiceImpl115 implements ContentService115 {

    @Autowired(required = false)
    private TbContentMapper tbContentMapper;

    @Override
    public EasyUIDataGridResult getContentListByCategoryId(Long categoryId, int page, int rows) {
        PageHelper.startPage(page, rows);

        List<TbContent> tbContents = new ArrayList<>();
        if (categoryId == 0L) {
            tbContents = tbContentMapper.getAllContentList();
        } else {
            tbContents = tbContentMapper.getContentListByCategoryId(categoryId);
        }

        PageInfo<TbContent> pageInfo = new PageInfo<>(tbContents);
        EasyUIDataGridResult easyUIDataGridResult = new EasyUIDataGridResult();
        easyUIDataGridResult.setRows(tbContents);
        easyUIDataGridResult.setTotal(pageInfo.getTotal());
        return easyUIDataGridResult;
    }

    @Override
    public TaotaoResult insertContent(TbContent tbContent) {
        tbContent.setCreated(new Date());
        tbContent.setUpdated(new Date());
        tbContentMapper.insertContent(tbContent);
        return TaotaoResult.ok();
    }
}
