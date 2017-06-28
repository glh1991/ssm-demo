package me.allensea.controller.filter;

import me.allensea.page.PageContext;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by allen on 17/6/26.
 */
public class PageFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        int pageNo = Integer.parseInt(filterConfig.getInitParameter("pageNo"));
        int pageRow = Integer.parseInt(filterConfig.getInitParameter("pageRow"));
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        PageContext.setPageNo(
                this.String2Int(request.getParameter("pageNo"), PageContext.DEFAULT_PAGENO));
        PageContext.setPageRow(
                this.String2Int(request.getParameter("pageRow"), PageContext.DEFAULT_PAGEROW));
        try {
            chain.doFilter(request, response);
        } finally {
            //清空ThreadLocal中的值
            PageContext.removePageNo();
            PageContext.removeRowCount();
        }

    }

    @Override
    public void destroy() {
        // do nothing
    }

    private int String2Int(String value, int defaultValue) {
        try {
            return Integer.parseInt(value);
        } catch (Exception e) {
            return defaultValue;
        }

    }
}
