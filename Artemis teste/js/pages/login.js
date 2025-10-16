document.addEventListener('DOMContentLoaded',()=>{
  const form=document.getElementById('loginForm');
  form.addEventListener('submit',e=>{
    e.preventDefault();
    const u=document.getElementById('email').value.trim();
    const p=document.getElementById('password').value.trim();
    const r=document.getElementById('role').value;
    if(u==='admin'&&p==='admin'){ saveSession('token-fake',r,{nome:'Administrador',email:'admin@artemis'}); location.href = r==='PROFESSOR'?'pages/dashboard-professor.html':'pages/dashboard-aluno.html'; }
    else toast('Credenciais inválidas');
  });
});