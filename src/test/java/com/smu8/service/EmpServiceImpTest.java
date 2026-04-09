package com.smu8.service;

import com.smu8.dto.EmpDto;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class EmpServiceImpTest {
    static EmpService empService;

    static {
        try {
            empService = new EmpServiceImp();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void removeEmp() throws SQLException {
        empService.removeEmp(7698);
    }
    @Test
    void getDetail() throws SQLException {
        EmpDto emp=empService.getDetail(5555);
        System.out.println(emp);
    }
    @Test
    void getEmps() {
        System.out.println(empService.getEmps());
    }

    @Test
    void testGetEmps() {
        System.out.println(empService.getEmps(10));
    }

    @Test
    void searchEmps() {
        System.out.println(empService.searchEmps("er"));
    }

    @Test
    void registerEmp() throws SQLException {
        EmpDto emp=new EmpDto(
                88,
                "service88",
                "tester",
                null,
                LocalDate.now(),
                100.0,
                11.0,
                10
        );
        empService.registerEmp(emp);
    }

    @Test
    void modifyEmp() throws SQLException {
        EmpDto emp=new EmpDto(
                88,
                "수정이",
                "modify",
                7654,
                LocalDate.of(1988,1,1),
                1234.11,
                34.22,
                10
        );
        empService.modifyEmp(emp);
    }
}