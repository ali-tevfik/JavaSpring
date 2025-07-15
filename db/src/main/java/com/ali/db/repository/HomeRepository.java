package com.ali.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ali.db.entites.Home;

@Repository
public interface HomeRepository extends JpaRepository<Home,Long> {

}
