package com.erayt.timing.service.impl;

import com.erayt.timing.service.ImportService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @Auther: Z151
 * @Date: 2021/3/30 10:29
 */
@Slf4j
@Service
public class ImportServiceImpl implements ImportService{
    @Value("${erayt.mergeFilePath}")
    private String mergeFilePath;
    @Value("${erayt.importFilePath}")
    private String importFilePath;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;
    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.driver-class-name}")
    private String className;

    @Override
    public void run() {
        invokeMergeSql();
        invokeFileImport();
    }

    /**
     * 执行mergeSql文件。
     */
    public void invokeMergeSql(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, username, password);
            conn.setAutoCommit(false);
            File files = new File(mergeFilePath);
            if(!files.exists()){
                boolean mkdirs = files.mkdirs();
                if(!mkdirs){
                    log.error("系统检测到路径【{}】不存在，创建该路径时出错。",mergeFilePath);
                }
            }
            File[] files1 = files.listFiles();
            if(null ==files1 || files1.length!=0){
                ScriptRunner runner = new ScriptRunner(conn);
                for (File file : files1) {
                    Reader read = new FileReader(file);
                    runner.runScript(read);
                    log.info("执行sql文件{}成功。",file.getName());
                }
                conn.close();
            }
        } catch (SQLException throwables) {
            log.error("数据库连接出现异常。",throwables);
        } catch (Exception e){
            log.error("数据导入出现异常。",e);
        }finally {
            if(null != conn){
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    log.error("执行过程中出现异常，finally中关闭连接池出现异常。",throwables);
                }
            }
        }
    }

    /**
     * 执行文件导入功能
     */
    public void invokeFileImport(){
        try {
            File files = new File(importFilePath);
            if(!files.exists()){
                boolean mkdirs = files.mkdirs();
                if(!mkdirs){
                    log.error("系统检测到路径【{}】不存在，创建该路径时出错。",importFilePath);
                }
            }
            File[] files1 = files.listFiles();
            if(null ==files1 || files1.length!=0){
                log.info("//TODO:此处应该写一些对文件的处理操作。");
            }
        } catch (Exception e){
            log.error("数据导入出现异常。",e);
        }
    }
}
