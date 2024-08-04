package com.airtribe.SpringBootApplication.repository;

import com.airtribe.SpringBootApplication.entity.Cohort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CohortRepository extends JpaRepository<Cohort, Long> {
}
