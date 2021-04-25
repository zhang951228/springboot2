package designPattern.builder;

import lombok.ToString;

import java.util.Set;

/**
 * @Auther: Z151
 * @Date: 2021/4/22 17:47
 */
@ToString
public class Role {
    private Integer id;
    private String name;
    private String power;
    private String type;
    /** 称谓 **/
    private String appellation;
    /** 授课科目 **/
    private Set<String> subject;

    public Role(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAppellation(String appellation) {
        this.appellation = appellation;
    }

    public void setSubject(Set<String> subject) {
        this.subject = subject;
    }
}
