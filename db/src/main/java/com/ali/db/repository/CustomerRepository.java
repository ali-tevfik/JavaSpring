package com.ali.db.repository;

import org.springframework.stereotype.Repository;
import com.ali.db.entites.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long>{}
    