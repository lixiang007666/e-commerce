package top.lixiang007.taotao.mapper;

import top.lixiang007.taotao.pojo.TbItemDesc;

public interface TbItemDescMapper {

    void insert(TbItemDesc tbItemDesc);

    TbItemDesc selectItemDescByPrimaryKey(Long itemId);
}
