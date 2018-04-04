package com.weproud.authservice.service;

import com.weproud.authservice.entity.User;
import com.weproud.authservice.repository.UserRepository;
import com.weproud.authservice.user.AuthUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

/**
 * @author Logan. 81k
 */

@Slf4j
@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        // 사용자를 확인 할 수 있도록 구현한다.
        User user = this.userRepository.findByAccount(username);
        if (ObjectUtils.isEmpty(user))
            throw new UsernameNotFoundException(username);
        log.debug("user: {}", user);

        return new AuthUser(user);
    }
}
