const sessionProf = protectPage(['PROFESSOR']);
document.addEventListener('DOMContentLoaded', ()=>{
  document.getElementById('nomeProfessor').textContent = sessionProf.user ? sessionProf.user.nome : 'Professor';
  document.getElementById('userInfo').textContent = sessionProf.user ? sessionProf.user.email||'' : '';
  document.getElementById('linkLogout').addEventListener('click', logout);
  loadProfessorDashboard();
});
async function loadProfessorDashboard(){
  try{
    const turmas = await apiFetch('/turmas');
    document.getElementById('kpiTurmas').textContent = Array.isArray(turmas)?turmas.length:0;
    const alunos = await apiFetch('/alunos');
    document.getElementById('kpiAlunos').textContent = Array.isArray(alunos)?alunos.length:0;
  }catch(e){ console.error(e); }
}