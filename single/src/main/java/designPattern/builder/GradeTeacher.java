package designPattern.builder;

/**
 * @Auther: Z151
 * @Date: 2021/4/22 17:53
 */
public class GradeTeacher extends RoleBuilder {

    public GradeTeacher(Integer id) {
        role = new Role(id);
    }

    @Override
    public void setName() {
        role.setName("张大头");
    }

    @Override
    public void setPower() {
        role.setPower("_ROLE_2");
    }

    @Override
    public void setType() {
        role.setType("2");
    }

    @Override
    public void setAppellation() {
        role.setAppellation("张班主任");
    }

    @Override
    public Role gtRole() {
        return role;
    }
}
