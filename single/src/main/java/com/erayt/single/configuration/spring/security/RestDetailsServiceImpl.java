/*
package com.erayt.single.configuration.spring.security;

import com.erayt.single.domain.enums.RoleEnum;
import com.erayt.single.service.UserService;
import com.erayt.single.virtual.VisitUser;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

*/
/**
 * @author :  z151
 * Description :  验证通过之后,第二、三...请求，会调用此类
 *//*


@Component
public class RestDetailsServiceImpl implements UserDetailsService {

    private final UserService userService;

    @Autowired
    public RestDetailsServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //com.erayt.single.domain.User user = userService.queryById(1);
        com.erayt.single.domain.User user = VisitUser.getVisitUser();

        if (user == null) {
            throw new UsernameNotFoundException("Username  not found.");
        }

        ArrayList<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
        grantedAuthorities.add(new SimpleGrantedAuthority(RoleEnum.fromCode(user.getRole()).getRoleName()));

        return new User(user.getUserName(), user.getPassword(), grantedAuthorities);
    }
}
*/
package com.erayt.single.configuration.spring.security;
public class RestDetailsServiceImpl{}
