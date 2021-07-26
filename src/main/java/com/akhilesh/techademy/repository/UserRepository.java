package com.akhilesh.techademy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.akhilesh.techademy.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
