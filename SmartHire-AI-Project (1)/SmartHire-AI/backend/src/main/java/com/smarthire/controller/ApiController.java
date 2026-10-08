package com.smarthire.controller;
import org.springframework.web.bind.annotation.*; import com.smarthire.model.*; import com.smarthire.repository.*; import com.smarthire.service.*; import java.util.*;
@RestController @RequestMapping("/api")
public class ApiController {
 private final QuestionRepository questions; private final InterviewRepository interviews; private final InterviewService service; private final AiEvaluationService ai;
 public ApiController(QuestionRepository q,InterviewRepository i,InterviewService s,AiEvaluationService a){questions=q;interviews=i;service=s;ai=a;}
 @GetMapping("/health") public Map<String,String> health(){return Map.of("status","UP","application","SmartHire AI");}
 @GetMapping("/questions") public List<Question> questions(@RequestParam(defaultValue="TECHNICAL") String type){return questions.findByType(type);}
 @PostMapping("/interviews") public Interview create(@RequestBody Map<String,String> b){return service.create(b.getOrDefault("candidateName","Candidate"),b.getOrDefault("type","TECHNICAL"));}
 @GetMapping("/interviews") public List<Interview> all(){return interviews.findAll();}
 @GetMapping("/interviews/{id}") public Interview one(@PathVariable Long id){return interviews.findById(id).orElseThrow();}
 @PostMapping("/interviews/{id}/answers") public Map<String,Object> answer(@PathVariable Long id,@RequestBody Map<String,Object> b){return service.answer(id,Long.valueOf(b.get("questionId").toString()),b.get("answer").toString());}
 @PostMapping("/interviews/{id}/complete") public Interview complete(@PathVariable Long id){return service.complete(id);}
 @PostMapping("/ai/evaluate") public Map<String,Object> evaluate(@RequestBody Map<String,String> b){return ai.evaluate(b.getOrDefault("question",""),b.getOrDefault("answer",""));}
}
