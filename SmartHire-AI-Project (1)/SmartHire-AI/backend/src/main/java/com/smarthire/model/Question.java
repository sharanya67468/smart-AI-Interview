package com.smarthire.model;
import jakarta.persistence.*;
@Entity
public class Question {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 private String text; private String category; private String type;
 public Question(){} public Question(String text,String category,String type){this.text=text;this.category=category;this.type=type;}
 public Long getId(){return id;} public String getText(){return text;} public String getCategory(){return category;} public String getType(){return type;}
 public void setId(Long id){this.id=id;} public void setText(String v){text=v;} public void setCategory(String v){category=v;} public void setType(String v){type=v;}
}
