package designPattern.builder;

import lombok.ToString;

/**
 * @Auther: Z151
 * @Date: 2021/4/22 17:53
 */
@ToString
public class SingleTeacher extends RoleBuilder {

    public SingleTeacher(Integer id) {
        role = new Role(id);
    }

    @Override
    public void setName() {
        role.setName("胡图图");
    }

    @Override
    public void setPower() {
        role.setPower("_ROLE_1");
    }

    @Override
    public void setType() {
        role.setType("1");
    }

    @Override
    public void setAppellation() {
        role.setAppellation("胡老师");
    }

    @Override
    public Role gtRole() {
        return role;
    }
}
