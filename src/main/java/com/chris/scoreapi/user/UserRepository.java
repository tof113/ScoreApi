package com.chris.scoreapi.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {

    User findByUser(Integer userId);

    User findByEmail(String email);

    Optional<User> findByUsername(String userName);


}
