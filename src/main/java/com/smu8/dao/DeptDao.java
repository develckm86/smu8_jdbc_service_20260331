package com.smu8.dao;

import com.smu8.dto.DeptDto;

import java.sql.SQLException;
import java.util.List;
//PreparedStatement, Statement, ResultSet auto close 구현
public interface DeptDao extends AutoCloseable{
    //CRUD
    //get : 부서전체조회,상세조회
    //register : 부서등록 (이미존재하는 부서번호 체크)
    //modify : 부서수정  (존재하지 않는 부서번호 체크)
    //remove : 부서삭제 dept-emp (자식데이터를 null), (존재하지 않는 부서번호 체크)
    List<DeptDto> findAll() throws SQLException;
    DeptDto findByDeptno(int deptno) throws SQLException;
    void insert(DeptDto dto) throws SQLException;
    int update(DeptDto dto) throws SQLException;
    int delete(int deptno) throws SQLException;
    //사원의 부서 번호를 null 로  (부서 삭제시 자식데이터 처리) => EmpDao 에서 처리
    //int updateDeptToNull(int deptno) throws SQLException;
}
