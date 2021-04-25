package designPattern.builder;

/**
 * @Auther: Z151
 * @Date: 2021/4/22 17:51
 */
public abstract class RoleBuilder {
    protected Role role;

    public abstract void setName();

    public abstract void setPower();

    public abstract void setType();

    public abstract void setAppellation();

    public abstract Role gtRole();
}
