package com.erayt.analysis.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Date;

/**
 * 登录用户基础信息 对应数据表（t_user）
 * @Auther: Z151
 * @Date: 2021/4/1 11:53
 */
@TableName("t_user")
@ToString
@Data
@EqualsAndHashCode
public class User {
    /** 顺序号 **/
    private Integer id;
    /** 用户账户 **/
    private String account;

    private String password;
    private String userName;
    private String realName;
    private Integer age;
    /** 性别：1：男  2：女 **/
    private Integer sex;
    private Date birthDay;
    /** 用户所拥有的规则权限。 **/
    private Integer role;
    /** 用户账户所处状态。禁用、密码过期、欠费、删除、 **/
    private Integer status;
    private Date createTime;
    private Date modifyTime;
    private Date lastActiveTime;
}
