package top.lixiang007.taotao.common.pojo;

import java.util.List;
/**
 * @Author Xiang Li
 * @Date 2021/8/24 下午12:25
 * @Since version-1.0
 * @青软实训
 */

public class EasyUIDataGridResult {

    private long total;

    private List<?> rows;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }
}
