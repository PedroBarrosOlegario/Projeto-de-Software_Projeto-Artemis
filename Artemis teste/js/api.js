// Wrapper fetch com timeout e headers
async function apiFetch(path, opts = {}){
  const url = path.startsWith('http') ? path : (API_BASE_URL + path);
  const controller = new AbortController();
  const id = setTimeout(()=>controller.abort(), TIMEOUT_MS);
  const token = sessionStorage.getItem('token');
  const headers = Object.assign({}, opts.headers || {});
  if(!headers['Content-Type'] && !(opts.body instanceof FormData)) headers['Content-Type'] = 'application/json';
  if(token) headers['Authorization'] = 'Bearer ' + token;
  try{
    const res = await fetch(url, Object.assign({}, opts, { headers, signal: controller.signal }));
    clearTimeout(id);
    if(res.status === 401){ sessionStorage.clear(); location.href = '/index.html'; throw new Error('Unauthorized'); }
    if(res.status === 204) return null;
    const text = await res.text();
    try{ return JSON.parse(text); }catch(e){ return text; }
  }catch(err){
    console.error('apiFetch error', err);
    throw err;
  }
}
