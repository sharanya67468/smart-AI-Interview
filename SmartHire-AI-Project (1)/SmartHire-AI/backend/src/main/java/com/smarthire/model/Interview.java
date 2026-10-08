package com.smarthire.model;
import jakarta.persistence.*; import java.time.LocalDateTime; import java.util.*;
@Entity
public class Interview {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 private String candidateName; private String type; private Double score; private String status; private LocalDateTime createdAt;
 @ManyToMany private List<Question> questions=new ArrayList<>();
 public Interview(){createdAt=LocalDateTime.now();status="IN_PROGRESS";}
 public Long getId(){return id;} public String getCandidateName(){return candidateName;} public String getType(){return type;} public Double getScore(){return score;} public String getStatus(){return status;} public LocalDateTime getCreatedAt(){return createdAt;} public List<Question> getQuestions(){return questions;}
 public void setId(Long v){id=v;} public void setCandidateName(String v){candidateName=v;} public void setType(String v){type=v;} public void setScore(Double v){score=v;} public void setStatus(String v){status=v;} public void setQuestions(List<Question> v){questions=v;}
}
