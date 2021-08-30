package top.lixiang007.taotao.portal.service;

import top.lixiang007.taotao.pojo.TbContent;

import java.util.List;

/**
 * @Author Xiang Li
 * @Date 2021/8/30 上午10:16
 * @Since version-1.0
 * @青软实训  首页
 */

public interface ContentService {

	List<TbContent> getContentList(long categoryId);
}
