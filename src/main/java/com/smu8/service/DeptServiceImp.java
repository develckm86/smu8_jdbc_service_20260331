package com.smu8.service;

import com.smu8.DBManager;
import com.smu8.dao.DeptDao;
import com.smu8.dao.DeptDaoImp;
import com.smu8.dto.DeptDto;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class DeptServiceImp implements  DeptService{

    private final HikariDataSource dataSource;

    public DeptServiceImp(){
        this.dataSource= DBManager.getInstance().getDataSource();
    }

    public DeptServiceImp(HikariDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<DeptDto> getAll() throws SQLException {
        List<DeptDto> depts=null;
        try(Connection conn=dataSource.getConnection();
            DeptDao deptDao=new DeptDaoImp(conn);){
            depts=deptDao.findAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return depts;
    }

    @Override
    public DeptDto get(int id) throws SQLException {
        DeptDto dept=null;
        try (Connection conn=dataSource.getConnection();
            DeptDao deptDao=new DeptDaoImp(conn)){
            dept=deptDao.findByDeptno(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return dept;
    }
    //dml : 트랜잭션을 구성해야하나?? (한서비스에 dml 이 2개 이상 ), DQL 여러개는 상관없음
    @Override
    public void register(DeptDto dto) throws SQLException, IllegalArgumentException {
        try (Connection conn=dataSource.getConnection();
            DeptDao deptDao=new DeptDaoImp(conn)){
            //1. pk 가 중복인지 확인
            DeptDto exitDept=deptDao.findByDeptno(dto.getDeptno());
            if(exitDept!=null) throw new IllegalArgumentException("존재하는 부서입니다.");
            //2. 등록
            deptDao.insert(dto);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void modify(DeptDto dto) throws SQLException, IllegalArgumentException {

    }

    @Override
    public void remove(int id) throws SQLException, IllegalArgumentException {

    }
}
