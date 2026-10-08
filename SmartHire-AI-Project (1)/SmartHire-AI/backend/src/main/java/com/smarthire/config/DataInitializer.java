package com.smarthire.config;
import org.springframework.boot.CommandLineRunner; import org.springframework.context.annotation.*; import com.smarthire.model.Question; import com.smarthire.repository.QuestionRepository;
@Configuration
public class DataInitializer {
 @Bean CommandLineRunner seed(QuestionRepository r){return args->{
  if(r.count()==0){
   r.save(new Question("Explain the four pillars of Object-Oriented Programming.","Java","TECHNICAL"));
   r.save(new Question("What is the difference between ArrayList and LinkedList in Java?","Java","TECHNICAL"));
   r.save(new Question("Explain dependency injection and why Spring Boot uses it.","Spring Boot","TECHNICAL"));
   r.save(new Question("What is a REST API? Explain HTTP methods with examples.","Web","TECHNICAL"));
   r.save(new Question("What is normalization in a relational database?","SQL","TECHNICAL"));
   r.save(new Question("Tell me about yourself and a project you are proud of.","HR","HR"));
   r.save(new Question("Describe a difficult problem you solved and how you approached it.","HR","HR"));
  }
 };}
}
