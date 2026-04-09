package com.smu8.dto;

public class DeptDto {
    private int deptno; //pk Number(2)
    private String dename;// Varchar2(14)
    private String loc;// Varchar2(13)

    public DeptDto(){}

    public DeptDto(int deptno, String dename, String loc) {
        this.deptno = deptno;
        this.dename = dename;
        this.loc = loc;
    }

    @Override
    public String toString() {
        return "{" +
                "deptno=" + deptno +
                ", dename='" + dename + '\'' +
                ", loc='" + loc + '\'' +
                '}'+'\n';
    }

    public int getDeptno() {
        return deptno;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    public String getDename() {
        return dename;
    }

    public void setDename(String dename) {
        this.dename = dename;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }
}
