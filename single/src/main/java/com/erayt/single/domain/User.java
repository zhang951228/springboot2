package com.erayt.single.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Generated;
import lombok.ToString;

import java.util.Date;

/**
 * 用户基本信息
 * @Auther: Z151
 * @Date: 2021/3/4 15:21
 */
@ToString
@Generated
@EqualsAndHashCode
@Data
public class User {

	private Integer id;

	private String userUuid;

	private String userName;

	private String password;
	/** 用户真实姓名 **/
	private String realName;

	private Integer age;

	private Integer sex;

	private Date birthDay;
	/** 用户等级 **/
	private Integer userLevel;

	private String phone;

	private Integer role;

	private Integer status;

	private String imagePath;

	private Date createTime;

	private Date modifyTime;

	private Date lastActiveTime;

	private Boolean deleted;

	private String wxOpenId;

}
