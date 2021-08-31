package top.lixiang007.taotao.portal.service.impl;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import top.lixiang007.taotao.common.pojo.TaotaoResult;
import top.lixiang007.taotao.common.utils.HttpClientUtil;
import top.lixiang007.taotao.common.utils.JsonUtils;
import top.lixiang007.taotao.pojo.TbContent;
import top.lixiang007.taotao.portal.pojo.AdNode;
import top.lixiang007.taotao.portal.service.ContentService;

import java.util.ArrayList;
import java.util.List;
/**
 * @Author Xiang Li
 * @Date 2021/8/31 上午10:27
 * @Since version-1.0
 * @青软实训 首页广告查询service
 */

@Service
public class ContentServiceImpl implements ContentService {

    @Value("${REST_BASE_URL}")
    private String REST_BASE_URL;
    @Value("${REST_CONTENT_URL}")
    private String REST_CONTENT_URL;
    @Value("${REST_CONTENT_AD1_CID}")
    private String REST_CONTENT_AD1_CID;

    @Override
    public String getAdList() {
        String json = HttpClientUtil.doGet(REST_BASE_URL + REST_CONTENT_URL + REST_CONTENT_AD1_CID);
        TaotaoResult taotaoResult = TaotaoResult.formatToList(json, TbContent.class);
        List<TbContent> contents = (List<TbContent>) taotaoResult.getData();

        List<AdNode> adNodes = new ArrayList<>();
        for (TbContent content : contents) {
            AdNode adNode = new AdNode();
            adNode.setHeight(240);
            adNode.setWidth(670);
            adNode.setSrc(content.getPic());

            adNode.setHeightB(240);
            adNode.setWidthB(550);
            adNode.setSrcB(content.getPic2());

            adNode.setAlt(content.getSubTitle());
            adNode.setHref(content.getUrl());

            adNodes.add(adNode);
        }
        return JsonUtils.objectToJson(adNodes);
    }
}
