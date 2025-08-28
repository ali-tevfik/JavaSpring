package com.ali.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ali.model.Address;

@Repository
public interface addressRepository  extends JpaRepository <Address,Long>{

}
