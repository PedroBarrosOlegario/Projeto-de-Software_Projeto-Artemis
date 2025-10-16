const s = getSession();
document.addEventListener('DOMContentLoaded', ()=>{
  document.getElementById('userName').textContent = s.user? s.user.nome : '';
  document.getElementById('btnNovo').addEventListener('click', ()=>{ openModal(); });
  loadList();
});
let editingId = null;
function openModal(item){
  document.getElementById('uniNome').value = item? (item['uniNome' ] || item['Nome'] || '') : '';
  editingId = item? item.id : null; showModal('modal');
}
async function save(){
  try{
    const body = {
      'uniNome': document.getElementById('uniNome').value,
    };
    if(editingId) await apiFetch('/universidades/'+editingId, { method:'PUT', body: JSON.stringify(body) });
    else await apiFetch('/universidades', { method:'POST', body: JSON.stringify(body) });
    hideModal('modal'); loadList(); toast('Salvo');
  }catch(e){ toast('Erro'); }
}
async function loadList(){
  try{ const list = await apiFetch('/universidades');
    if(!Array.isArray(list) || list.length===0){ document.getElementById('lista').innerHTML = '<p>Sem dados</p>'; return;}
    const rows = list.map(it=>`<tr>${Object.values(it).map(v=>`<td>${escapeHtml(v)}</td>`).join('')}<td><button onclick="editItem(${it.id})" class='btn'>Editar</button> <button onclick="delItem(${it.id})" class='btn ghost'>Excluir</button></td></tr>`).join('');
    const heads = Object.keys(list[0]).map(h=>`<th>${h}</th>`).join('');
    document.getElementById('lista').innerHTML = `<table class='table'><thead><tr>${heads}<th>Ações</th></tr></thead><tbody>${rows}</tbody></table>`;
  }catch(e){ document.getElementById('lista').innerHTML = '<p>Erro ao carregar</p>'; }
}
async function editItem(id){ const it = await apiFetch('/universidades/'+id); openModal(it); }
async function delItem(id){ if(!confirm('Confirmar?')) return; await apiFetch('/universidades/'+id, { method:'DELETE' }); loadList(); }
document.getElementById('save_universidades')?.addEventListener('click', save);