package com.smu8.service;

import com.smu8.dto.DeptDto;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class DeptServiceImpTest {
    static DeptService deptService=new DeptServiceImp();

    @Test
    void getAll() throws SQLException {
        System.out.println(deptService.getAll());
    }

    @Test
    void get() throws SQLException {
        System.out.print(deptService.get(10));
        System.out.print(deptService.get(20));
        System.out.print(deptService.get(77));
    }

    @Test
    void register() throws SQLException {
        DeptDto dto=new DeptDto(
                77,
                "ai",
                "부산"
        );
        deptService.register(dto);
    }
}