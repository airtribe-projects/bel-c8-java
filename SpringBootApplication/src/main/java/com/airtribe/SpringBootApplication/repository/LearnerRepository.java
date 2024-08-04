package com.airtribe.SpringBootApplication.repository;

import com.airtribe.SpringBootApplication.entity.Learner;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LearnerRepository extends JpaRepository<Learner, Long> {
  List<Learner> findByLearnerName(String learnerName);
}
