// static login (admin/admin)
document.getElementById('loginForm').addEventListener('submit', (e)=>{
  e.preventDefault();
  const username = document.getElementById('email').value.trim();
  const password = document.getElementById('password').value.trim();
  const role = document.getElementById('role').value;
  if(username === 'admin' && password === 'admin'){
    const user = { nome: 'Administrador', email: 'admin@artemis.local', id: 1 };
    saveSession('token-fake', role, user);
    toast('Login efetuado (estático)');
    if(role === 'PROFESSOR') location.href = 'pages/dashboard-professor.html'; else location.href = 'pages/dashboard-aluno.html';
  }else{
    toast('Usuário ou senha incorretos');
  }
});