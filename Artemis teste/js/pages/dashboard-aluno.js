const sessionAluno = protectPage(['ALUNO','PROFESSOR']);
document.addEventListener('DOMContentLoaded', ()=>{
  document.getElementById('nomeAluno').textContent = sessionAluno.user ? sessionAluno.user.nome : 'Aluno';
  document.getElementById('userInfo').textContent = sessionAluno.user ? sessionAluno.user.email||'' : '';
  document.getElementById('linkLogout').addEventListener('click', logout);
  loadAlunoDashboard();
});
async function loadAlunoDashboard(){
  try{
    const turmas = await apiFetch('/turmas');
    document.getElementById('kpiTurmas').textContent = Array.isArray(turmas)?turmas.length:0;
    const disciplinas = await apiFetch('/disciplinas');
    document.getElementById('kpiDisciplinas').textContent = Array.isArray(disciplinas)?disciplinas.length:0;
  }catch(e){ console.error(e); }
}