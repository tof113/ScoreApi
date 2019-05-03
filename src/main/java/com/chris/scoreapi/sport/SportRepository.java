package com.chris.scoreapi.sport;

import org.springframework.data.jpa.repository.JpaRepository;


public interface SportRepository extends JpaRepository<Sport,Integer> {

    Sport findByName(String name);
}
