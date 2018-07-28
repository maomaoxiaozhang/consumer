package com.alibaba.middleware.tddl.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.alibaba.middleware.tddl.Salary;

/**
 * 通过直接注入JdbcTemplate方式进行查询的例子,详情见
 * http://gitlab.alibaba-inc.com/middleware-container/pandora-boot/wikis/spring-boot-tddl
 *
 * @author chengxu
 */
@Component
public class JdbcQueryDemo {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Salary> query(String sql) {
        return jdbcTemplate.query(sql, new RowMapper<Salary>() {

            @Override
            public Salary mapRow(ResultSet paramResultSet, int paramInt) throws SQLException {
                Salary salary = new Salary();
                salary.setEmpNo(paramResultSet.getLong("emp_no"));
                salary.setSalary(paramResultSet.getLong("salary"));
                salary.setFromDate(paramResultSet.getDate("from_date"));
                salary.setToDate(paramResultSet.getDate("to_date"));
                return salary;
            }
        });
    }
}
