package top.lixiang007.taotao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.lixiang007.taotao.common.pojo.EasyUIDataGridResult;
import top.lixiang007.taotao.common.pojo.TaotaoResult;
import top.lixiang007.taotao.common.utils.IDUtils;
import top.lixiang007.taotao.mapper.TbItemDescMapper;
import top.lixiang007.taotao.mapper.TbItemMapper;
import top.lixiang007.taotao.mapper.TbItemParamItemMapper;
import top.lixiang007.taotao.pojo.TbItem;
import top.lixiang007.taotao.pojo.TbItemDesc;
import top.lixiang007.taotao.pojo.TbItemParamItem;
import top.lixiang007.taotao.service.ItemService;


import java.util.Date;
import java.util.List;
/**
 * @Author Xiang Li
 * @Date 2021/8/24 下午12:33
 * @Since version-1.0
 * @青软实训
 */

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired(required = false)
    private TbItemMapper tbItemMapper;
    @Autowired(required = false)
    private TbItemDescMapper tbItemDescMapper;
    @Autowired(required = false)
    private TbItemParamItemMapper tbItemParamItemMapper;


    @Override
    public TbItem getItemById(Long id) {
        return tbItemMapper.selectByPrimaryKey(id);
    }

    @Override
    public EasyUIDataGridResult getItemList(int page, int rows) {
        PageHelper.startPage(page, rows);
        List<TbItem> itemList = tbItemMapper.getItemList();

        PageInfo<TbItem> pageInfo = new PageInfo<>(itemList);

        EasyUIDataGridResult easyUIDataGridResult = new EasyUIDataGridResult();
        easyUIDataGridResult.setRows(itemList);
        easyUIDataGridResult.setTotal(pageInfo.getTotal());

        return easyUIDataGridResult;
    }

    /**
     * @Author Xiang Li
     * @Date 2021/8/25 下午8:39
     * @Since version-1.0
     * @青软实训 添加商品 和图像上传有关系 泪目了
     */

    @Override
    public TaotaoResult createItem(TbItem item, String desc, String itemParam) {
        // 生成商品ID
        long itemId = IDUtils.genItemId();
        item.setId(itemId);
        // 商品状态，1-正常，2-下架，3-删除
        item.setStatus((byte) 1);
        // 创建时间和更新时间
        Date date = new Date();
        item.setCreated(date);
        item.setUpdated(date);
        // 插入商品表
        tbItemMapper.insert(item);

        TbItemDesc tbItemDesc = new TbItemDesc();
        tbItemDesc.setItemId(itemId);
        tbItemDesc.setItemDesc(desc);
        tbItemDesc.setCreated(date);
        tbItemDesc.setUpdated(date);
        tbItemDescMapper.insert(tbItemDesc);
/**
 * @Author Xiang Li
 * @Date 2021/8/27 上午10:34
 * @Since version-1.0
 * @青软实训 添加规格参数
 */

        TbItemParamItem tbItemParamItem = new TbItemParamItem();
        tbItemParamItem.setItemId(itemId);
        tbItemParamItem.setParamData(itemParam);
        tbItemParamItem.setCreated(date);
        tbItemParamItem.setUpdated(date);
        tbItemParamItemMapper.insert(tbItemParamItem);

        return TaotaoResult.ok();
    }
}
