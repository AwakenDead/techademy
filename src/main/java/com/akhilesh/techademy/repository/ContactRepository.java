package com.akhilesh.techademy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.akhilesh.techademy.entity.Contact;
@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {

}
