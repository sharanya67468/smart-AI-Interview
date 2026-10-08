package com.smarthire.model;
import jakarta.persistence.*;
@Entity
public class Answer {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 private Long interviewId; private Long questionId; @Column(length=4000) private String answer; private Double score; @Column(length=4000) private String feedback;
 public Long getId(){return id;} public Long getInterviewId(){return interviewId;} public Long getQuestionId(){return questionId;} public String getAnswer(){return answer;} public Double getScore(){return score;} public String getFeedback(){return feedback;}
 public void setInterviewId(Long v){interviewId=v;} public void setQuestionId(Long v){questionId=v;} public void setAnswer(String v){answer=v;} public void setScore(Double v){score=v;} public void setFeedback(String v){feedback=v;}
}
