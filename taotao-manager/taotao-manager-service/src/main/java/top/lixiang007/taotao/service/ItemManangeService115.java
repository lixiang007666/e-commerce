package top.lixiang007.taotao.service;

import org.springframework.web.bind.annotation.RequestParam;
import top.lixiang007.taotao.common.pojo.TaotaoResult;
import top.lixiang007.taotao.pojo.TbItem;

public interface ItemManangeService115 {
    /**
     * 商品下架
     */
    TaotaoResult instockItem(@RequestParam("ids") long itemId, TbItem item);

    /**
     * 商品上架
     */
    TaotaoResult reshelfItem(@RequestParam("ids") long itemId, TbItem item);
}
