package designPattern.builder;

/**
 * @Auther: Z151
 * @Date: 2021/4/22 18:03
 */
public class RoleDirector {
    public static void directorRole1(RoleBuilder roleAbstract){
        roleAbstract.setAppellation();
        roleAbstract.setName();
        roleAbstract.setType();
        roleAbstract.setPower();
    }
}
