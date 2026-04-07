package com.smu8;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;

class DBManagerTest {

    @Test
    void getInstance() {
        DBManager dbManager=DBManager.getInstance();
        System.out.println(dbManager);
        assertNotNull(dbManager);
    }
    //@ 어노테이션 : 컴파일단계에서 오류검사, 자동완성 @Override @FunctaionalInterface..
    @Test
    void getConnection() throws SQLException {
        DBManager dbManager=DBManager.getInstance();
        Connection connection=dbManager.getConnection();
        Statement st=connection.createStatement();
        ResultSet rs=st.executeQuery("SELECT * FROM EMP");
        while (rs.next()){
            System.out.println(rs.getString("ename"));
        }
    }
}