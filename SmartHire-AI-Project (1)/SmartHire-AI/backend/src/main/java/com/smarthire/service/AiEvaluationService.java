package com.smarthire.service;
import org.springframework.stereotype.Service; import java.util.*;
@Service
public class AiEvaluationService {
 public Map<String,Object> evaluate(String question,String answer){
   int words=answer.trim().isEmpty()?0:answer.trim().split("\\s+").length;
   int score=Math.min(10,Math.max(2,words/12+3));
   Map<String,Object> r=new LinkedHashMap<>();
   r.put("score",score);
   r.put("summary", words<20 ? "The answer is brief. Add a clear explanation, an example, and the result." : "The answer has useful detail. Make the structure more direct and connect the explanation to a practical example.");
   r.put("strengths", List.of("Attempted the question", "Uses your own explanation"));
   r.put("improvements", List.of("Use a clear structure", "Add a concrete project or coding example", "Mention trade-offs where relevant"));
   r.put("suggestedAnswer","Start with the definition, explain how it works, give a small example, and finish with a practical use case.");
   return r;
 }
}
