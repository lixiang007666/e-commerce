package top.lixiang007.taotao.mapper;

import top.lixiang007.taotao.pojo.TbItem;

import java.util.List;

public interface TbItemMapper {

    TbItem selectByPrimaryKey(Long id);

    List<TbItem> getItemList();

    void insert(TbItem item);
}