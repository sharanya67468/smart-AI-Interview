const API = "http://localhost:8080/api";
let sessionId = null, questions = [], current = 0, score = 0;

async function startInterview(){
  try{
    const res = await fetch(API + "/interviews", {method:"POST",headers:{"Content-Type":"application/json"},body:JSON.stringify({candidateName:"Sharanya",type:"TECHNICAL"})});
    const data = await res.json();
    sessionId = data.id;
    questions = data.questions;
    current = 0; score = 0;
    document.getElementById("interview").classList.remove("hidden");
    renderQuestion();
    location.hash = "interview";
  }catch(e){alert("Start the Spring Boot backend first: " + e.message);}
}

function renderQuestion(){
  if(current >= questions.length){finishInterview();return;}
  document.getElementById("questionTitle").textContent = questions[current].category;
  document.getElementById("questionText").textContent = questions[current].text;
  document.getElementById("counter").textContent = `Question ${current+1} / ${questions.length}`;
  document.getElementById("answer").value = "";
  document.getElementById("feedback").classList.add("hidden");
}

async function submitAnswer(){
  const answer = document.getElementById("answer").value.trim();
  if(!answer){alert("Please enter an answer.");return;}
  const q = questions[current];
  const res = await fetch(`${API}/interviews/${sessionId}/answers`,{method:"POST",headers:{"Content-Type":"application/json"},body:JSON.stringify({questionId:q.id,answer})});
  const data = await res.json();
  score += data.evaluation.score;
  showFeedback(data.evaluation);
}

function showFeedback(e){
  const box=document.getElementById("feedback");
  box.innerHTML=`<h3>AI Feedback: ${e.score}/10</h3><p>${e.summary}</p><b>Strengths</b><ul>${e.strengths.map(x=>`<li>${x}</li>`).join("")}</ul><b>Improve</b><ul>${e.improvements.map(x=>`<li>${x}</li>`).join("")}</ul>`;
  box.classList.remove("hidden");
  setTimeout(()=>{current++;renderQuestion()},1200);
}

function skipQuestion(){current++;renderQuestion();}

async function finishInterview(){
  await fetch(`${API}/interviews/${sessionId}/complete`,{method:"POST"});
  const avg = Math.round((score / questions.length) * 10) / 10;
  document.querySelector(".score").textContent = avg + "/10";
  loadHistory();
  alert(`Interview completed. Score: ${avg}/10`);
}

async function loadHistory(){
  try{
    const res=await fetch(API+"/interviews");
    const data=await res.json();
    const list=document.getElementById("historyList");
    if(!data.length){list.innerHTML='<p class="muted">No completed sessions yet.</p>';return;}
    list.innerHTML=data.map(x=>`<div class="history-row"><span>${x.type} Interview</span><b>${x.score ?? "In progress"}</b></div>`).join("");
  }catch(e){}
}
loadHistory();
