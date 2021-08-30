package top.lixiang007.taotao.portal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import top.lixiang007.taotao.common.pojo.TaotaoResult;
import top.lixiang007.taotao.common.utils.HttpClientUtil;
import top.lixiang007.taotao.pojo.TbContent;
import top.lixiang007.taotao.portal.service.ContentService;

/**
 * @Author Xiang Li
 * @Date 2021/8/30 上午10:15
 * @Since version-1.0
 * @青软实训
 */


@Service
public class ContentServiceImpl implements ContentService {
	
	@Value("${SERVICE_BASE_URL}")
	private String SERVICE_BASE_URL ;
	@Value("${INDEX_AD1_URL}")
	private String INDEX_AD1_URL ;


	@Override
	public List<TbContent> getContentList(long categoryId) {
		//调用服务层的服务
		String resStr = HttpClientUtil.doGet(SERVICE_BASE_URL + INDEX_AD1_URL + categoryId);
		//把字符串转换成java对象
		TaotaoResult result = TaotaoResult.formatToList(resStr, TbContent.class);
		if (result.getStatus() == 200) {
			List<TbContent> listContent = (List<TbContent>) result.getData();
			return listContent;
		}
		return null;
	}

}
