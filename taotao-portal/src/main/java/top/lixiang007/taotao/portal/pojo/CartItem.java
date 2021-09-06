package top.lixiang007.taotao.portal.pojo;
/**
 * @Author Xiang Li
 * @Date 2021/9/6 上午9:46
 * @Since version-1.0
 * @青软实训
 */

public class CartItem {
    private Long id;
    private String title;
    private Long price;
    private Integer num;
    private String image;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
