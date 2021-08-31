package top.lixiang007.taotao.rest.service;



import top.lixiang007.taotao.common.pojo.TaotaoResult;
import top.lixiang007.taotao.pojo.TbContent;

import java.util.List;
/**
 * @Author Xiang Li
 * @Date 2021/8/31 上午9:53
 * @Since version-1.0
 * @青软实训 内容查询服务发布 首页做的查询？？？？？？？
 */

public interface ContentService115 {
    List<TbContent> getContentList(Long cid);
    TaotaoResult syncContent(Long cid);
}
