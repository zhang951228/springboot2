package com.erayt.analysis.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Auther: Z151
 * @Date: 2021/3/11 14:31
 * 触发用户时间时的传递 POJO
 */
@Data
public class UserEventLog implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private Integer account;
	private String userName;
	private String realName;
	private String content;
	private Date createTime;
}
