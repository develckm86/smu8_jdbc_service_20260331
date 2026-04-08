package com.smu8.dao;

import com.smu8.DBManager;
import com.smu8.dto.EmpDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmpDaoImpTest {
    static DBManager dbManager=DBManager.getInstance();
    static EmpDao empDao;
    static {
        try {
            empDao = new EmpDaoImp(dbManager.getConnection());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void insert() throws SQLException {
        //타입보다 크기가 클때,참조할 부모가 없을때 (emp,deptno), 사원번호가 이미 사용중
        EmpDto emp=new EmpDto(
                5555,
                "test5",
                "test5",
                3333,
                LocalDate.now(),
                5555.0,
                55.0,
                30
        );
        empDao.insert(emp);
    }

    @Test
    void update() throws SQLException {
        EmpDto emp=new EmpDto(
                5555,
                "upTester5",
                "upTest5",
                7902,
                LocalDate.of(2002,2,2),
                2002.0,
                22.0,
                20
        );
        int update=empDao.update(emp);
        System.out.println(update); //존재하는 사원이면 1
    }

    @Test
    void delete() {
    }

    @Test
    void deletePayHistroy() {
    }

    @Test
    void findAll() throws SQLException {
        List<EmpDto> emps=empDao.findAll();
        System.out.println(emps);

    }

    @Test
    void findByEmpno() throws SQLException {
        EmpDto emp=empDao.findByEmpno(7369);
        System.out.println(emp);
        //Assertions.assertNotNull(emp);
    }
    //**ai (test)
    @Test
    void findByDeptno() throws SQLException{
        List<EmpDto> emps =empDao.findByDeptno(20);
        System.out.println(emps);
    }

    @Test
    void findByEnameContaining() throws SQLException {
        List<EmpDto> emps=empDao.findByEnameContaining("i");
        System.out.println(emps);
    }
}