package com.erayt.dbconnector.domain;

import lombok.Data;

/**
 * @Auther: Z151
 * @Date: 2021/3/12 17:50
 */
@Data
public class User {
	private Long id;
	private String name;
	private Integer age;
	private String email;
}
