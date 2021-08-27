package top.lixiang007.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import top.lixiang007.taotao.service.ItemParamItemService115;

/**
 * @Author Xiang Li
 * @Date 2021/8/27 上午10:58
 * @Since version-1.0
 * @青软实训
 */

@Controller
public class ItemParamItemController115 {

	@Autowired
	private ItemParamItemService115 itemParamItemService115;
	
	@RequestMapping("/showParam/{itemId}")
	public String showParam(@PathVariable Long itemId, Model model) {
		String string = itemParamItemService115.getItemParemById115(itemId);
		/**
		 * @Author Xiang Li
		 * @Date 2021/8/27 上午11:00
		 * @Since version-1.0
		 * @青软实训 展示商品规格参数
		 */

		model.addAttribute("html", string);
		return "item-param";
	}
	
}
