package top.lixiang007.taotao.rest.service.impl;


import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import top.lixiang007.taotao.common.utils.JsonUtils;
import top.lixiang007.taotao.mapper.TbItemDescMapper;
import top.lixiang007.taotao.mapper.TbItemMapper;
import top.lixiang007.taotao.mapper.TbItemParamItemMapper;
import top.lixiang007.taotao.pojo.TbItem;
import top.lixiang007.taotao.pojo.TbItemDesc;
import top.lixiang007.taotao.pojo.TbItemParamItem;
import top.lixiang007.taotao.rest.component.JedisClient;
import top.lixiang007.taotao.rest.service.ItemService115;

/**
 * 商品管理Service
 */
/**
 * @Author Xiang Li
 * @Date 2021/9/2 上午11:27
 * @Since version-1.0
 * @青软实训  点击商品 跳转查看商品信息
 */

@Service
public class ItemServiceImpl115 implements ItemService115 {

    @Autowired(required = false)
    private TbItemMapper tbItemMapper;
    @Autowired(required = false)
    private TbItemDescMapper tbItemDescMapper;
    @Autowired(required = false)
    private TbItemParamItemMapper tbItemParamItemMapper;
    @Autowired(required = false)
    private JedisClient jedisClient;
    @Value("${REDIS_ITEM_KEY}")
    private String REDIS_ITEM_KEY;
    @Value("${ITEM_BASE_INFO_KEY}")
    private String ITEM_BASE_INFO_KEY;
    @Value("${ITEM_DESC_KEY}")
    private String ITEM_DESC_KEY;
    @Value("${ITEM_PARAM_KEY}")
    private String ITEM_PARAM_KEY;
    @Value("${ITEM_EXPIRE_SECOND}")
    private Integer ITEM_EXPIRE_SECOND;

    @Override
    public TbItem getItemById(Long itemId) {
        // 查询缓存，如果有缓存，直接返回
        try {
            String json = jedisClient.get(REDIS_ITEM_KEY + ":" + itemId + ":" + ITEM_BASE_INFO_KEY);
            if (StringUtils.isNotBlank(json)) {
                return JsonUtils.jsonToPojo(json, TbItem.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 查询数据库
        TbItem tbItem = tbItemMapper.selectByPrimaryKey(itemId);

        // 向redis中添加缓存，有效期为1天
        try {
            jedisClient.set(REDIS_ITEM_KEY + ":" + itemId + ":" + ITEM_BASE_INFO_KEY, JsonUtils.objectToJson(tbItem));
            jedisClient.expire(REDIS_ITEM_KEY + ":" + itemId + ":" + ITEM_BASE_INFO_KEY, ITEM_EXPIRE_SECOND);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tbItem;
    }

    @Override
    public TbItemDesc getItemDescById(Long itemId) {
        // 查询缓存，如果有缓存，直接返回
        try {
            String json = jedisClient.get(REDIS_ITEM_KEY + ":" + itemId + ":" + ITEM_DESC_KEY);
            if (StringUtils.isNotBlank(json)) {
                return JsonUtils.jsonToPojo(json, TbItemDesc.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 查询数据库
        TbItemDesc tbItemDesc = tbItemDescMapper.selectItemDescByPrimaryKey(itemId);

        // 向redis中添加缓存，有效期为1天
        try {
            jedisClient.set(REDIS_ITEM_KEY + ":" + itemId + ":" + ITEM_DESC_KEY, JsonUtils.objectToJson(tbItemDesc));
            jedisClient.expire(REDIS_ITEM_KEY + ":" + itemId + ":" + ITEM_DESC_KEY, ITEM_EXPIRE_SECOND);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return tbItemDesc;
    }

    @Override
    public TbItemParamItem getItemParamById(Long itemId) {
        // 查询缓存，如果有缓存，直接返回
        try {
            String json = jedisClient.get(REDIS_ITEM_KEY + ":" + itemId + ":" + ITEM_PARAM_KEY);
            if (StringUtils.isNotBlank(json)) {
                return JsonUtils.jsonToPojo(json, TbItemParamItem.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 查询数据库
        TbItemParamItem tbItemParamItem = tbItemParamItemMapper.selectItemParamByItemId(itemId);

        // 向redis中添加缓存，有效期为1天
        try {
            jedisClient.set(REDIS_ITEM_KEY + ":" + itemId + ":" + ITEM_PARAM_KEY, JsonUtils.objectToJson(tbItemParamItem));
            jedisClient.expire(REDIS_ITEM_KEY + ":" + itemId + ":" + ITEM_PARAM_KEY, ITEM_EXPIRE_SECOND);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tbItemParamItem;
    }
}
