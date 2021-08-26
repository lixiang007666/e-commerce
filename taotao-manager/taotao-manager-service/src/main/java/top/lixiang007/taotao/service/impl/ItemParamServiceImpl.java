package top.lixiang007.taotao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import top.lixiang007.taotao.common.pojo.EasyUIDataGridResult;
import top.lixiang007.taotao.common.pojo.TaotaoResult;
import top.lixiang007.taotao.mapper.TbItemParamMapper;
import top.lixiang007.taotao.pojo.TbItemParam;
import top.lixiang007.taotao.pojo.TbItemParamAndName;
import top.lixiang007.taotao.service.ItemParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author Xiang Li
 * @Date 2021/8/26 上午10:51
 * @Since version-1.0
 * @青软实训 既一类商品对应一个规格参数，规格参数是可以添加的，如果存在则不能添加。
 */

@Service
public class ItemParamServiceImpl implements ItemParamService {

    @Autowired(required = false)
    private TbItemParamMapper tbItemParamMapper;

    @Override
    public EasyUIDataGridResult getItemParamList(int page, int rows) {
        PageHelper.startPage(page, rows);
        List<TbItemParamAndName> itemParamList = tbItemParamMapper.getItemParamList();

        PageInfo<TbItemParamAndName> pageInfo = new PageInfo<>(itemParamList);
        EasyUIDataGridResult easyUIDataGridResult = new EasyUIDataGridResult();
        easyUIDataGridResult.setRows(itemParamList);
        easyUIDataGridResult.setTotal(pageInfo.getTotal());

        return easyUIDataGridResult;
    }

    @Override
    public TaotaoResult getItemParamByCid(Long cid) {
        TbItemParam itemParam = tbItemParamMapper.getItemParamByCid(cid);
        if (itemParam != null) {
            return TaotaoResult.ok(itemParam);
        }
        return TaotaoResult.ok();
    }

    @Override
    public TaotaoResult insertItemParam(Long cid, String paramData) {
        TbItemParam tbItemParam = new TbItemParam();
        tbItemParam.setItemCatId(cid);
        tbItemParam.setParamData(paramData);
        tbItemParam.setCreated(new Date());
        tbItemParam.setUpdated(new Date());
        int result = tbItemParamMapper.insertItemParam(tbItemParam);
        if (result > 0) {
            return TaotaoResult.ok();
        } else {
            return TaotaoResult.build(400, "新增商品规格参数失败");
        }
    }
}
