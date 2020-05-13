package com.ykb.cloud;

public class Department {

    private String name;
    private String domain;
    private String support;
    private int    employeeCount;

    public String getName() {
        return this.name;
    }

    public void setName(final String nameParam) {
        this.name = nameParam;
    }

    public String getDomain() {
        return this.domain;
    }

    public void setDomain(final String domainParam) {
        this.domain = domainParam;
    }

    public String getSupport() {
        return this.support;
    }

    public void setSupport(final String supportParam) {
        this.support = supportParam;
    }

    public int getEmployeeCount() {
        return this.employeeCount;
    }

    public void setEmployeeCount(final int employeeCountParam) {
        this.employeeCount = employeeCountParam;
    }

    @Override
    public String toString() {
        return "Department [name="
               + this.name
               + ", domain="
               + this.domain
               + ", support="
               + this.support
               + ", employeeCount="
               + this.employeeCount
               + "]";
    }

}
