package top.lixiang007.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import top.lixiang007.taotao.common.pojo.PictureResult;
import top.lixiang007.taotao.common.utils.JsonUtils;
import top.lixiang007.taotao.service.PictureService;


/**
 * @Author Xiang Li
 * @Date 2021/8/25 下午6:11
 * @Since version-1.0
 * @青软实训 图像上传
 */

@Controller
public class PictureController {
	@Autowired
	private PictureService pictureService;
	
	@RequestMapping("/pic/upload")
	@ResponseBody
	public String upload(MultipartFile uploadFile) {
		PictureResult result = pictureService.uploadPicture(uploadFile);
		return JsonUtils.objectToJson(result);
	}
	
}
