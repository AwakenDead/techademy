package com.akhilesh.techademy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.akhilesh.techademy.entity.Feedback;
@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {

}
