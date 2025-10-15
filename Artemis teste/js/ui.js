// small UI helpers
function toast(msg, timeout=3000){
  const el = document.createElement('div');
  el.className = 'toast';
  el.textContent = msg;
  document.body.appendChild(el);
  setTimeout(()=>el.remove(), timeout);
}
function escapeHtml(s){ return String(s==null?'':s).replace(/&/g,'&amp;').replace(/</g,'&lt;').replace(/>/g,'&gt;'); }
// modal helpers
function showModal(id){ document.getElementById(id).classList.add('show'); }
function hideModal(id){ document.getElementById(id).classList.remove('show'); }
