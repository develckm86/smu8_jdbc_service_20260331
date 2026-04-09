package com.smu8.dao;

import com.smu8.dto.DeptDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeptDaoImp implements DeptDao{

    private PreparedStatement ps;
    private ResultSet rs;
    private final Connection conn;
    public DeptDaoImp(Connection conn) {
        this.conn = conn;
    }

    public DeptDto parseDept(ResultSet rs) throws SQLException{
        return new DeptDto(
                rs.getInt("deptno"),
                rs.getString("dname"),
                rs.getString("loc")
        );
    }
    @Override
    public List<DeptDto> findAll() throws SQLException {
        List<DeptDto> depts=null;
        String sql="SELECT * FROM DEPT";
        ps=conn.prepareStatement(sql);
        rs=ps.executeQuery();
        depts=new ArrayList<>();
        while (rs.next()){
            depts.add(parseDept(rs));
        }
        return depts;
    }

    @Override
    public DeptDto findByDeptno(int deptno) throws SQLException {
        DeptDto dept=null;
        String sql="SELECT * FROM DEPT WHERE DEPTNO=?";
        ps=conn.prepareStatement(sql);
        ps.setInt(1,deptno);
        rs=ps.executeQuery();
        if(rs.next()){
            dept=parseDept(rs);
        }
        return dept;
    }

    @Override
    public void insert(DeptDto dto) throws SQLException {
        String sql="INSERT INTO DEPT (DEPTNO, DNAME, LOC) VALUES (?,?,?)";
        ps=conn.prepareStatement(sql);
        ps.setInt(1,dto.getDeptno());
        ps.setString(2,dto.getDename());
        ps.setString(3,dto.getLoc());
        ps.executeUpdate();
    }
    @Override
    public int update(DeptDto dto) throws SQLException {
        int update=0;
        String sql="UPDATE DEPT SET DNAME=?, LOC=? WHERE DEPTNO=?";
        ps=conn.prepareStatement(sql);
        ps.setString(1,dto.getDename());
        ps.setString(2,dto.getLoc());
        ps.setInt(3,dto.getDeptno());
        update=ps.executeUpdate();
        return update;
    }

    @Override
    public int delete(int deptno) throws SQLException {
        int delete=0;
        String sql="DELETE FROM DEPT WHERE DEPTNO=?";
        ps=conn.prepareStatement(sql);
        ps.setInt(1,deptno);
        delete=ps.executeUpdate();
        return delete;
    }

    @Override
    public void close() throws Exception {
        if(rs!=null) rs.close();
        if(ps!=null) ps.close();
        //conn 서비스에서 close()
    }
}
