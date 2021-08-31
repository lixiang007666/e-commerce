package top.lixiang007.taotao.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.lixiang007.taotao.common.pojo.TaotaoResult;
import top.lixiang007.taotao.common.utils.ExceptionUtil;
import top.lixiang007.taotao.pojo.TbContent;
import top.lixiang007.taotao.rest.service.ContentService115;

import java.util.List;

/**
 * 内容查询Controller
 */
/**
 * @Author Xiang Li
 * @Date 2021/8/31 上午9:58
 * @Since version-1.0
 * @青软实训
 */

@Controller
@RequestMapping("/content")
public class ContentController115 {

    @Autowired(required = false)
    private ContentService115 contentService;

    @ResponseBody
    @RequestMapping("/{cid}")
    /**
     * @Author Xiang Li
     * @Date 2021/8/31 上午9:58
     * @Since version-1.0
     * @青软实训 cid表示类别id designed by 李响
     */

    public TaotaoResult getContentList(@PathVariable Long cid) {
        try {
            List<TbContent> contentList = contentService.getContentList(cid);
            return TaotaoResult.ok(contentList);
        } catch (Exception e) {
            e.printStackTrace();
            return TaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
        }
    }

    @ResponseBody
    @RequestMapping("/sync/{cid}")
    public TaotaoResult syncContent(@PathVariable Long cid) {
        try {
            return contentService.syncContent(cid);
        } catch (Exception e) {
            return TaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
        }

    }
}
