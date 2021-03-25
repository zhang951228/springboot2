package com.erayt.dbconnector.domain;

import lombok.Data;
import lombok.ToString;

/**
 * @Auther: Z151
 * @Date: 2021/3/12 17:50
 */
@ToString
@Data
public class User {
	private Long id;
	private String name;
	private Integer age;
	private String email;
}
