package com.alibaba.middleware.tddl;

import java.sql.Date;

/**
 * tddl里自动生成的虚拟表对应的类
 * @author chengxu
 */
public class Salary {

    private long empNo;

    private long salary;

    private Date fromDate;

    private Date toDate;

    public long getEmpNo() {
        return empNo;
    }

    public void setEmpNo(long empNo) {
        this.empNo = empNo;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    @Override
    public String toString() {
        return "Salary [emp_no=" + empNo + ", salary=" + salary + ", from_date=" + fromDate + ", to_date=" + toDate
               + "]";
    }
}
