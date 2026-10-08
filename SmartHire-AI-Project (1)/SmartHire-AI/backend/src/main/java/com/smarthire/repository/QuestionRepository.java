package com.smarthire.repository;
import org.springframework.data.jpa.repository.JpaRepository; import com.smarthire.model.Question; import java.util.*;
public interface QuestionRepository extends JpaRepository<Question,Long>{List<Question> findByType(String type);}
