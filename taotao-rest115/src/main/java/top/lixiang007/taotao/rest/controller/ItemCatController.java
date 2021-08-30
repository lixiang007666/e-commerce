package top.lixiang007.taotao.rest.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.lixiang007.taotao.common.utils.JsonUtils;
import top.lixiang007.taotao.rest.pojo.ItemCatResult;
import top.lixiang007.taotao.rest.service.ItemCatService;


/**
 * @Author Xiang Li
 * @Date 2021/8/30 上午11:12
 * @Since version-1.0
 * @青软实训 商品分类服务 webinf目录下的json数据是为了模拟静态 这里取数据库里的数据
 */

@Controller
@RequestMapping("/item/cat")
public class ItemCatController {

	@Autowired(required = false)
	private ItemCatService itemCatService;
//
//	@RequestMapping("/list")
//	@ResponseBody
//	public Object getItemCatList(String callback) {
//		ItemCatResult result = itemCatService.getItemCatList();
//		//判断是否是jsonp调用
//		if (StringUtils.isBlank(callback)) {
//			return result;
//		}
//		//jsonp包装
//		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(result);
//		mappingJacksonValue.setJsonpFunction(callback);
//
//		return mappingJacksonValue;
//	}
//	//jsonp第二种方法
	@RequestMapping(value="/list", produces=MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
	@ResponseBody
	public String getItemCatList(String callback) {
		ItemCatResult result = itemCatService.getItemCatList();
		//判断是否是jsonp调用
		if (StringUtils.isBlank(callback)) {
			return JsonUtils.objectToJson(result);
		}

		return callback + "(" + JsonUtils.objectToJson(result) + ");";
	}
}
