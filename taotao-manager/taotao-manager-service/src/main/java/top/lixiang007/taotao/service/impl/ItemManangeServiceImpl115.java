package top.lixiang007.taotao.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import top.lixiang007.taotao.common.pojo.TaotaoResult;
import top.lixiang007.taotao.mapper.TbItemMapper;
import top.lixiang007.taotao.pojo.TbItem;
import top.lixiang007.taotao.service.ItemManangeService115;

import java.util.Date;
/**
 * @Author Xiang Li
 * @Date 2021/9/7 下午12:03
 * @Since version-1.0
 * @青软实训
 */
@Service
public class ItemManangeServiceImpl115 implements ItemManangeService115 {


    @Autowired(required = false)
    private TbItemMapper itemMapper;
    /**
     * 下架商品
     */
    @Override
    public TaotaoResult instockItem(@RequestParam("ids") long itemId, TbItem item){

        item=itemMapper.selectByPrimaryKey(itemId);
        item.setStatus((byte) 2);
        item.setCreated(item.getCreated());
        item.setUpdated(new Date());
        itemMapper.updateByPrimaryKeySelective(item);
        return TaotaoResult.ok();
    }




    /**
     * 上架商品
     */
    @Override
    public TaotaoResult reshelfItem(@RequestParam("ids") long itemId, TbItem item) {
        item=itemMapper.selectByPrimaryKey(itemId);
        item.setStatus((byte) 1);
        item.setCreated(item.getCreated());
        item.setUpdated(new Date());
        itemMapper.updateByPrimaryKeySelective(item);
        return TaotaoResult.ok();
    }

}
