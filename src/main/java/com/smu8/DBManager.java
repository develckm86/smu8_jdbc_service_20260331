package com.smu8;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBManager {

    private final static DBManager INSTANCE = new DBManager();
    private HikariDataSource dataSource;
    private final static String URL="jdbc:oracle:thin:@//localhost:1521/XEPDB1";
    private final static String USER="scott";
    private final static String PW="tiger";
    private DBManager(){
        HikariConfig config=new HikariConfig();
        config.setMaximumPoolSize(10);
        config.setJdbcUrl(URL);
        config.setUsername(USER);
        config.setPassword(PW);
        dataSource=new HikariDataSource(config);
    }

    public static DBManager getInstance(){
        return INSTANCE;
    }
    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

}


//class DBManagerTest{
//    public static void main(String[] args) {
//        DBManager dbManager=DBManager.getInstance();
//        try (Connection conn=dbManager.getConnection();
//             Statement st=conn.createStatement();
//             ResultSet rs=st.executeQuery("SELECT empno result FROM EMP")
//        ){
//            while (rs.next()){
//                System.out.println(rs.getInt("result"));
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//}


