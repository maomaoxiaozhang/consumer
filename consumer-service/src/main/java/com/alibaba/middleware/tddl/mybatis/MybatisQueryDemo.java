package com.alibaba.middleware.tddl.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.middleware.tddl.Salary;

/**
 * 通过mybatis进行查询的例子，详见http://www.mybatis.org/spring-boot-starter/mybatis-spring-boot-autoconfigure/
 *
 * @author chengxu
 */
@Component
@EnableTransactionManagement
public class MybatisQueryDemo {

    @Autowired
    private SalaryMapper salaryMapper;

    public List<Salary> query() {
        return salaryMapper.selectSalaryByEmpNo(-1);
    }

}
