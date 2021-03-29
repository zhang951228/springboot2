/*
package com.erayt.single.configuration.spring.security;

import com.erayt.single.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

*/
/**
 * @Auther: Z151
 * @Date: 2021/3/29 15:38
 *//*

//@Configuration
//@EnableWebSecurity
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

    //@Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(new RestDetailsServiceImpl(userService)).passwordEncoder(passwordEncoder());
        //super.configure(auth);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            //antMatchers("/","/index") .permitAll()这一行代码是值针对某些路径直接放行，所有用户都可以访问，主要用于我们的首页、静态资源、登录注册等
            .antMatchers("/","/index","/logout","/static/*")
            .permitAll()
            //antMatchers("/admin").access("hasRole('admin')")这一行代码一样的，就是针对某些路径，只允许具备这个角色访问，
            // 也就是对角色的权限进行分配了（ps：这里需要注意，SpringSercurity会自动帮我们拼接“ROLE_”，
            // 也就是我们实际上是“ROLE_admin”而不是“admin”）
            .antMatchers("/admin").access("hasRole('STUDENT')")
            //hasAnyRole("admin","user")这行代码，就是指针对某些路径，可以多个角色一起访问，都具备访问资格
            .antMatchers("/main").hasAnyRole("STUDENT","ADMIN")
            .and()
            //开启我们的登录页面，
            .formLogin().loginPage("/login").defaultSuccessUrl("/main")
            .permitAll()
            .and()
            .logout()
            .permitAll();
        //super.configure(http);
    }
}
*/
package com.erayt.single.configuration.spring.security;
public class SecurityConfigurer{}
//TODO:若要开启security ，需要解开这两个文件的注解，同时 maven中需要增加依赖。