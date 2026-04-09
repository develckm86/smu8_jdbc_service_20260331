package com.smu8.service;

import com.smu8.dto.DeptDto;

import java.sql.SQLException;
import java.util.List;

public interface DeptService {
    //CRUD
    //get : 부서전체조회,상세조회
    //register : 부서등록 (이미존재하는 부서번호 체크)
    //modify : 부서수정  (존재하지 않는 부서번호 체크)
    //remove : 부서삭제 dept-emp (자식데이터를 null), (존재하지 않는 부서번호 체크)
    //** 오라클은 pk 수정을 권장하지 않음

    List<DeptDto> getAll() throws SQLException;
    DeptDto get(int id) throws  SQLException;
    void register(DeptDto dto) throws SQLException,IllegalArgumentException;
    void modify(DeptDto dto) throws SQLException,IllegalArgumentException;
    void remove(int id) throws SQLException,IllegalArgumentException;
}
