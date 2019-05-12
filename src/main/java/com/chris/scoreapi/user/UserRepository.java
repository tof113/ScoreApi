package com.chris.scoreapi.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

    User findByUser(int userId);

    User findByEmail(String email);


}
