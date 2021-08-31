package top.lixiang007.taotao.rest.service.impl;


import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import sun.dc.pr.PRError;
import top.lixiang007.taotao.common.pojo.TaotaoResult;
import top.lixiang007.taotao.common.utils.JsonUtils;
import top.lixiang007.taotao.mapper.TbContentMapper;
import top.lixiang007.taotao.pojo.TbContent;
import top.lixiang007.taotao.rest.component.JedisClient;
import top.lixiang007.taotao.rest.service.ContentService115;

import java.util.List;
/**
 * @Author Xiang Li
 * @Date 2021/8/31 上午9:54
 * @Since version-1.0
 * @青软实训
 */

@Service
public class ContentServiceImpl115 implements ContentService115 {

    @Autowired(required = false)
    private TbContentMapper tbContentMapper;
    @Autowired(required = false)
    private JedisClient jedisClient;
    @Value("${REDIS_CONTENT_KEY}")
    private String REDIS_CONTENT_KEY;

    @Override
    public List<TbContent> getContentList(Long cid) {
        // 添加缓存
        // 查询数据库之前先查询缓存，如果有直接返回
        try {
            //从redis中取缓存数据
            String json = jedisClient.hget(REDIS_CONTENT_KEY, cid + "");
            if (!StringUtils.isBlank(json)) {
                return JsonUtils.jsonToList(json, TbContent.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<TbContent> tbContentList = tbContentMapper.getContentListByCategoryId(cid);

        // 返回结果之前，向缓存中添加数据
        try {
            jedisClient.hset(REDIS_CONTENT_KEY, cid + "", JsonUtils.objectToJson(tbContentList));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return tbContentList;
    }

    /**
     * 删除缓存来缓存同步
     * @param cid
     * @return
     */
    /**
     * @Author Xiang Li
     * @Date 2021/8/31 上午9:55
     * @Since version-1.0
     * @青软实训
     */

    @Override
    public TaotaoResult syncContent(Long cid) {
        Long result = jedisClient.hdel(REDIS_CONTENT_KEY, cid + "");
        if (result <= 0) {
            return TaotaoResult.build(204, "没有缓存可以同步");
        }
        return TaotaoResult.ok();
    }
}
