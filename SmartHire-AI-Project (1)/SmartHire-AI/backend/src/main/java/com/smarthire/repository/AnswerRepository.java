package com.smarthire.repository;
import org.springframework.data.jpa.repository.JpaRepository; import com.smarthire.model.Answer; import java.util.*;
public interface AnswerRepository extends JpaRepository<Answer,Long>{List<Answer> findByInterviewId(Long id);}
