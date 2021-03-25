package com.erayt.dbconnector;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan
@SpringBootApplication
public class DbconnectorApplication {
	public static void main(String[] args) {
		SpringApplication.run(DbconnectorApplication.class, args);
	}
}
