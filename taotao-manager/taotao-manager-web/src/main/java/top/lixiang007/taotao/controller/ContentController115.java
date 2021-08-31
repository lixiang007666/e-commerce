package top.lixiang007.taotao.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.lixiang007.taotao.common.pojo.EasyUIDataGridResult;
import top.lixiang007.taotao.common.pojo.TaotaoResult;
import top.lixiang007.taotao.common.utils.HttpClientUtil;
import top.lixiang007.taotao.pojo.TbContent;
import top.lixiang007.taotao.service.ContentService115;

/**
 * @Author Xiang Li
 * @Date 2021/8/31 上午9:42
 * @Since version-1.0
 * @青软实训 CMS内容管理
 */

@Controller
@RequestMapping("/content")
public class ContentController115 {
    /**
     * @Author Xiang Li
     * @Date 2021/8/31 上午9:45
     * @Since version-1.0
     * @青软实训 读取resources.properties designed by 李响
     */

    @Autowired
    private ContentService115 contentService;
    @Value("${REDIS_SYNC_BASE_URL}")
    private String REDIS_SYNC_BASE_URL;
    @Value("${REDIS_CONTENT_SYNC_URL}")
    private String REDIS_CONTENT_SYNC_URL;

    @ResponseBody
    @RequestMapping("/query/list")
    public EasyUIDataGridResult getContentListByCategoryId(Long categoryId, Integer page, Integer rows) {
        return contentService.getContentListByCategoryId(categoryId, page, rows);
    }

    /**
     * @Author Xiang Li
     * @Date 2021/8/31 上午9:42
     * @Since version-1.0
     * @青软实训 如添加一个大广告
     */

    @ResponseBody
    @RequestMapping("/save")
    public TaotaoResult insertContent(TbContent tbContent) {
        TaotaoResult result = contentService.insertContent(tbContent);
        HttpClientUtil.doGet(REDIS_SYNC_BASE_URL + REDIS_CONTENT_SYNC_URL + tbContent.getCategoryId());
        return result;
    }
}
