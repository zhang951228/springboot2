package com.erayt.timing.schedule;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * @Auther: Z151
 * @Date: 2021/3/30 09:45
 */
@SpringBootTest
class DynamicScheduleTaskTest {
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;
    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.driver-class-name}")
    private String className;


    @Test
    public void testConnection(){
        Connection conn = null;
        try {
            Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            conn = DriverManager.getConnection(url, username, password);
            conn.setAutoCommit(false);
            System.out.println("数据库连接成功...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}