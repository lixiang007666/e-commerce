package top.lixiang007.taotao.portal.pojo;

import java.util.List;

/**
 * Solr查询服务pojo
 */
/**
 * @Author Xiang Li
 * @Date 2021/9/2 上午10:42
 * @Since version-1.0
 * @青软实训
 */

public class SearchResult {

    private List<SearchItem> itemList;
    private Long recordCount;
    private int pageCount;
    private int currentPage;

    public List<SearchItem> getItemList() {
        return itemList;
    }

    public void setItemList(List<SearchItem> itemList) {
        this.itemList = itemList;
    }

    public Long getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(Long recordCount) {
        this.recordCount = recordCount;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
}
