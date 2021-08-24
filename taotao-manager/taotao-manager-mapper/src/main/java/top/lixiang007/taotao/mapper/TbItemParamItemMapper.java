package top.lixiang007.taotao.mapper;

import top.lixiang007.taotao.pojo.TbItemParamItem;

public interface TbItemParamItemMapper {
    void insert(TbItemParamItem tbItemParamItem);

    TbItemParamItem selectItemParamByItemId(Long itemId);
}
