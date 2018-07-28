package com.alibaba.middleware.tddl.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.alibaba.middleware.tddl.Salary;

/**
 * 使用mybatis进行查询的Mapper
 *
 * @author chengxu
 */
@Mapper
public interface SalaryMapper {

    /**
     * 根据员工号查询员工的工资流水
     * @param empNo 员工号
     * @return 工资流水
     */
    List<Salary> selectSalaryByEmpNo(int empNo);

}
