package com.erayt.single.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @Auther: Z151
 * @Date: 2021/3/11 14:31
 * 触发用户时间时的传递 POJO
 */
public class UserEventLog implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private Integer userId;
	private String userName;
	private String realName;
	private String content;
	private Date createTime;
}
