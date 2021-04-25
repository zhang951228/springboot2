package designPattern.builder;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * @Auther: Z151
 * @Date: 2021/4/22 18:05
 */
@Slf4j
class RoleDirectorTest {

    @Test
    public void test1(){
        //创建对象，赋予必须填写的内容值
        RoleBuilder singleTeacher = new SingleTeacher(1);
        //根据策略，给对应的附加属性赋值
        RoleDirector.directorRole1(singleTeacher);
        //获取该对象值。
        Role role = singleTeacher.gtRole();
        log.info(role.toString());

        RoleBuilder gradeTeacher = new GradeTeacher(2);
        RoleDirector.directorRole1(gradeTeacher);
        Role role1 = gradeTeacher.gtRole();
        log.info(role1.toString());
    }

}