package top.lixiang007.taotao.mapper;

import top.lixiang007.taotao.pojo.TbItemParam;
import top.lixiang007.taotao.pojo.TbItemParamAndName;

import java.util.List;

public interface TbItemParamMapper {

    List<TbItemParamAndName> getItemParamList();

    TbItemParam getItemParamByCid(Long cid);

    Integer insertItemParam(TbItemParam tbItemParam);
}
