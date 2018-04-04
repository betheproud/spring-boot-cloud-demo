package com.weproud.authservice.repository;

import com.weproud.authservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Logan. 81k
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findByAccount(String username);
}
