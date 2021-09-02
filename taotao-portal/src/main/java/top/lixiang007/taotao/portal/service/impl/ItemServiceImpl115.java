package top.lixiang007.taotao.portal.service.impl;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import top.lixiang007.taotao.common.pojo.TaotaoResult;
import top.lixiang007.taotao.common.utils.HttpClientUtil;
import top.lixiang007.taotao.common.utils.JsonUtils;
import top.lixiang007.taotao.pojo.TbItem;
import top.lixiang007.taotao.pojo.TbItemDesc;
import top.lixiang007.taotao.pojo.TbItemParamItem;
import top.lixiang007.taotao.portal.pojo.PortalItem115;
import top.lixiang007.taotao.portal.service.ItemService115;

import java.util.List;
import java.util.Map;

/**
 * 查询商品信息服务
 */
@Service
public class ItemServiceImpl115 implements ItemService115 {

    @Value("${REST_BASE_URL}")
    private String REST_BASE_URL;
    @Value("${REST_ITEM_BASE_URL}")
    private String REST_ITEM_BASE_URL;
    @Value("${REST_ITEM_DESC_URL}")
    private String REST_ITEM_DESC_URL;
    @Value("${REST_ITEM_PARAM_URL}")
    private String REST_ITEM_PARAM_URL;

    /**
     * 根据id查询商品基本信息
     * @param itemId
     * @return
     */
    @Override
    public TbItem getItemById(Long itemId) {
        String json = HttpClientUtil.doGet(REST_BASE_URL + REST_ITEM_BASE_URL + itemId);
        TaotaoResult taotaoResult = TaotaoResult.formatToPojo(json, PortalItem115.class);
        TbItem item = (TbItem) taotaoResult.getData();
        return item;
    }

    /**
     * 根据id查询商品描述
     * @param itemId
     * @return
     */
    @Override
    public String getItemDescById(Long itemId) {
        String json = HttpClientUtil.doGet(REST_BASE_URL + REST_ITEM_DESC_URL + itemId);
        TaotaoResult taotaoResult = TaotaoResult.formatToPojo(json, TbItemDesc.class);
        TbItemDesc tbItemDesc = (TbItemDesc) taotaoResult.getData();
        return tbItemDesc.getItemDesc();
    }

    /**
     * 根据id查询商品参数
     * @param itemId
     * @return
     */
    @Override
    public String getItemParamById(Long itemId) {
        String json = HttpClientUtil.doGet(REST_BASE_URL + REST_ITEM_PARAM_URL + itemId);
        TaotaoResult taotaoResult = TaotaoResult.formatToPojo(json, TbItemParamItem.class);
        TbItemParamItem tbItemParamItem = (TbItemParamItem) taotaoResult.getData();
        String paramData = tbItemParamItem.getParamData();
        // paramData是一个json，解析成map
        List<Map> paramList = JsonUtils.jsonToList(paramData, Map.class);

        // 遍历list生成html
        StringBuffer sb = new StringBuffer();

        sb.append("<table cellpadding=\"0\" cellspacing=\"1\" width=\"100%\" border=\"0\" class=\"Ptable\">\n");
        sb.append("	<tbody>\n");
        for (Map map : paramList) {
            sb.append("		<tr>\n");
            sb.append("			<th class=\"tdTitle\" colspan=\"2\">" + map.get("group") + "</th>\n");
            sb.append("		</tr>\n");
            // 取规格项
            List<Map> mapList2 = (List<Map>) map.get("params");
            for (Map map2 : mapList2) {
                sb.append("		<tr>\n");
                sb.append("			<td class=\"tdTitle\">" + map2.get("k") + "</td>\n");
                sb.append("			<td>" + map2.get("v") + "</td>\n");
                sb.append("		</tr>\n");
            }
        }
        sb.append("	</tbody>\n");
        sb.append("</table>");

        return sb.toString();
    }
}
