package com.smu8.dao;

import com.smu8.DBManager;
import com.smu8.dto.DeptDto;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class DeptDaoImpTest {
    //junit 단위 테스트 함수에서 필드를 참조하려면 static 이 가장 안전
    static DeptDao deptDao=null;
    static {
        try {
            Connection conn= DBManager.getInstance().getConnection();
            deptDao=new DeptDaoImp(conn);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    void findAll() throws SQLException {
        System.out.println(deptDao.findAll());
    }
    @Test
    void findByDeptno() throws SQLException {
        System.out.println(deptDao.findByDeptno(99));
    }
    @Test
    void insert() throws SQLException {
        //오류 : pk가 같은것이 있을때, 문자열길이가 길때
        DeptDto dept=new DeptDto(
                99,
                "개발",
                "서울"
        );
        deptDao.insert(dept);
    }

    @Test
    void update() throws SQLException {
        DeptDto dept=new DeptDto(
                99,
                "bigdata",
                "대전"
        );
        int update=deptDao.update(dept);
        System.out.println(update);
        System.out.println(deptDao.findByDeptno(99));
    }

    @Test
    void delete() throws SQLException {
        int id=10; //부서를 참조하는 사원이 있으면 삭제 불가!
        System.out.println(deptDao.findByDeptno(id)); //삭제전 확인
        System.out.println(deptDao.delete(id));//삭제
        System.out.println(deptDao.findByDeptno(id)); //삭제후 확인
    }
}