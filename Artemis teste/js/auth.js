// auth helpers (static login)
function saveSession(token, role, user){
  sessionStorage.setItem('token', token);
  sessionStorage.setItem('role', role);
  sessionStorage.setItem('user', JSON.stringify(user));
}
function getSession(){ return { token: sessionStorage.getItem('token'), role: sessionStorage.getItem('role'), user: JSON.parse(sessionStorage.getItem('user')||'null') }; }
function logout(){ sessionStorage.clear(); location.href = '/index.html'; }
function protectPage(allowedRoles){
  const s = getSession();
  if(!s.token || !allowedRoles.includes(s.role)){ location.href = '/index.html'; }
  return s;
}
