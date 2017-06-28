package me.allensea.dao.inteceptors;

import me.allensea.page.PageContext;
import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.Properties;

/**
 * sql 构造拦截器
 * Created by allen on 17/6/27.
 */
@Intercepts({ @Signature(type = StatementHandler.class, method = "prepare", args = {
        Connection.class, Integer.class }) })
public class StatementHandlerInteceptor implements Interceptor {
    @Autowired
    private DataSource dataSource;

    private static String SQL_D_PAGE = "D_PAGE";

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Connection pc = null;
        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
        MetaObject metaStatementHandler = SystemMetaObject.forObject(statementHandler);

        // 分离代理链
        while (metaStatementHandler.hasGetter("h")) {
            Object object = metaStatementHandler.getValue("h");
            metaStatementHandler = SystemMetaObject.forObject(object);
        }

        while (metaStatementHandler.hasGetter("target")) {
            Object object = metaStatementHandler.getValue("target");
            metaStatementHandler = SystemMetaObject.forObject(object);
        }
        MappedStatement mappedStatement = (MappedStatement) metaStatementHandler
                .getValue("delegate.mappedStatement");

        if (null != mappedStatement && null != mappedStatement.getId()
                && (mappedStatement.getId().indexOf("findPage") != -1
                || mappedStatement.getId().indexOf("findSimplePage") != -1)) {
            mappedStatement.getCache().clear();

            BoundSql boundSql = (BoundSql) metaStatementHandler.getValue("delegate.boundSql");
            // 分页参数作为参数对象parameterObject的一个属性
            String sql = boundSql.getSql();
            // 重写sql

            Connection conn = (Connection) invocation.getArgs()[0];

            if (conn.isClosed()) {
                pc = dataSource.getConnection();
                conn = pc;
                invocation.getArgs()[0] = pc;
            }

            int index = sql.indexOf(SQL_D_PAGE);
            boolean dfacePageSql = -1 != index;

            String pageSql = buildPageSqlForMysql(sql, dfacePageSql);
            metaStatementHandler.setValue("delegate.boundSql.sql", pageSql);

        }
        return invocation.proceed();
    }

    private String buildPageSqlForMysql(String sql, boolean dfacePageSql) {
        if (!dfacePageSql) {
            Integer pageNo = (Integer) PageContext.getPageNo();
            Integer pageRow = (Integer) PageContext.getPageRow();

            int endRow = pageRow;
            int startRow = (pageNo - 1) * pageRow;

            StringBuilder buffer = new StringBuilder(sql);
            buffer.append(" limit ");
            buffer.append(startRow);
            buffer.append(",");
            buffer.append(endRow);
            return buffer.toString();
        } else {
            Integer pageNo = (Integer) PageContext.getPageNo();
            Integer pageRow = (Integer) PageContext.getPageRow();
            int startRow = (pageNo - 1) * pageRow;
            String limit = String.format(" limit %d,1 ", startRow);
            sql = sql.replace(SQL_D_PAGE, limit).replace(SQL_D_PAGE.toUpperCase(), limit);
            return sql + " limit " + pageRow;

        }
    }

    @Override
    public Object plugin(Object target) {
        if (target instanceof StatementHandler || target instanceof ResultSetHandler) {
            return Plugin.wrap(target, this);
        } else {
            return target;
        }
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
