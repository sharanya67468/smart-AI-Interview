package com.smarthire.repository;
import org.springframework.data.jpa.repository.JpaRepository; import com.smarthire.model.Interview;
public interface InterviewRepository extends JpaRepository<Interview,Long>{}
