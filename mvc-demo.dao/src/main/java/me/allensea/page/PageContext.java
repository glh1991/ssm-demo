package me.allensea.page;

/**
 * Created by allen on 17/6/26.
 */
public class PageContext {

    // 默认页码
    public final static int DEFAULT_PAGENO = 1;
    // 默认行数
    public final  static int DEFAULT_PAGEROW = 20;
    public static ThreadLocal<Integer> pageNo  = new ThreadLocal<>();
    public static ThreadLocal<Integer> pageRow = new ThreadLocal<>();

    public static Integer getPageNo() {
        return pageNo.get();
    }

    public static void setPageNo(Integer pageNo) {
        PageContext.pageNo.set(pageNo);
    }

    public static Integer getPageRow() {
        return pageRow.get();
    }

    public static void setPageRow(Integer pageRow) {
        PageContext.pageRow.set(pageRow);
    }

    public static void removePageNo() {
        pageNo.remove();
    }

    public static void removeRowCount() {
        pageRow.remove();
    }
}
