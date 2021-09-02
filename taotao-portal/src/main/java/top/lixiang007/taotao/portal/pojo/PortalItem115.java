package top.lixiang007.taotao.portal.pojo;


import top.lixiang007.taotao.pojo.TbItem;
/**
 * @Author Xiang Li
 * @Date 2021/9/2 下午4:46
 * @Since version-1.0
 * @青软实训
 */

public class PortalItem115 extends TbItem {
    public String[] getImages() {
        String images = this.getImage();
        if (images != null && !images.equals("")) {
            String[] imgs = images.split(",");
            return imgs;
        }
        return null;
    }
}
