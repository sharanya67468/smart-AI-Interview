package com.smarthire.service;
import org.springframework.stereotype.Service; import com.smarthire.model.*; import com.smarthire.repository.*; import java.util.*;
@Service
public class InterviewService {
 private final InterviewRepository interviews; private final QuestionRepository questions; private final AnswerRepository answers; private final AiEvaluationService ai;
 public InterviewService(InterviewRepository i,QuestionRepository q,AnswerRepository a,AiEvaluationService ai){this.interviews=i;this.questions=q;this.answers=a;this.ai=ai;}
 public Interview create(String name,String type){
   Interview in=new Interview(); in.setCandidateName(name); in.setType(type);
   List<Question> qs=questions.findByType(type); if(qs.isEmpty()) qs=questions.findAll();
   in.setQuestions(qs.stream().limit(5).toList()); return interviews.save(in);
 }
 public Map<String,Object> answer(Long interviewId,Long questionId,String text){
   Map<String,Object> eval=ai.evaluate("",text); Answer a=new Answer();a.setInterviewId(interviewId);a.setQuestionId(questionId);a.setAnswer(text);a.setScore((Double)eval.get("score"));a.setFeedback((String)eval.get("summary"));answers.save(a);
   return Map.of("evaluation",eval);
 }
 public Interview complete(Long id){Interview in=interviews.findById(id).orElseThrow();List<Answer> as=answers.findByInterviewId(id);double s=as.stream().mapToDouble(x->x.getScore()==null?0:x.getScore()).average().orElse(0);in.setScore(Math.round(s*10.0)/10.0);in.setStatus("COMPLETED");return interviews.save(in);}
}
