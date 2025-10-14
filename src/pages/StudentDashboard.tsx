import { useAuth } from '../contexts/AuthContext';
import { Logo } from '../components/Logo';
import { useNavigate } from 'react-router-dom';

export function StudentDashboard() {
  const { profile, signOut } = useAuth();
  const navigate = useNavigate();

  const handleSignOut = async () => {
    try {
      await signOut();
      navigate('/login');
    } catch (error) {
      console.error('Error signing out:', error);
    }
  };

  const menuItems = [
    { title: 'Minhas Disciplinas', description: 'Visualize suas disciplinas matriculadas', icon: '📚' },
    { title: 'Histórico Acadêmico', description: 'Consulte seu histórico e notas', icon: '📊' },
    { title: 'Horários', description: 'Veja seus horários de aula', icon: '📅' },
    { title: 'Perfil', description: 'Gerencie suas informações pessoais', icon: '👤' },
  ];

  return (
    <div className="min-h-screen bg-gradient-to-br from-slate-50 to-slate-100">
      <nav className="bg-white shadow-sm border-b border-slate-200">
        <div className="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8">
          <div className="flex justify-between items-center h-16">
            <Logo />
            <div className="flex items-center gap-4">
              <span className="text-slate-600">Olá, {profile?.full_name}</span>
              <button
                onClick={handleSignOut}
                className="px-4 py-2 text-slate-600 hover:text-slate-900 transition"
              >
                Sair
              </button>
            </div>
          </div>
        </div>
      </nav>

      <main className="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8 py-8">
        <div className="mb-8">
          <h1 className="text-3xl font-bold text-slate-800 mb-2">Portal do Aluno</h1>
          <p className="text-slate-600">Bem-vindo ao seu portal acadêmico</p>
        </div>

        <div className="grid grid-cols-1 md:grid-cols-2 gap-6 mb-8">
          {menuItems.map((item, index) => (
            <div
              key={index}
              className="bg-white rounded-xl shadow-sm hover:shadow-md transition p-6 cursor-pointer border border-slate-100"
            >
              <div className="flex items-start gap-4">
                <div className="text-4xl">{item.icon}</div>
                <div className="flex-1">
                  <h3 className="text-lg font-semibold text-slate-800 mb-1">{item.title}</h3>
                  <p className="text-slate-600">{item.description}</p>
                </div>
              </div>
            </div>
          ))}
        </div>

        <div className="bg-white rounded-xl shadow-sm p-6 border border-slate-100">
          <h2 className="text-xl font-semibold text-slate-800 mb-4">Avisos Recentes</h2>
          <div className="space-y-4">
            <div className="border-l-4 border-slate-700 pl-4 py-2">
              <p className="text-slate-700 font-medium">Período de matrícula aberto</p>
              <p className="text-slate-600 text-sm">Não se esqueça de realizar sua matrícula para o próximo semestre</p>
            </div>
            <div className="border-l-4 border-slate-400 pl-4 py-2">
              <p className="text-slate-700 font-medium">Biblioteca disponível</p>
              <p className="text-slate-600 text-sm">Consulte o acervo digital da biblioteca universitária</p>
            </div>
          </div>
        </div>
      </main>
    </div>
  );
}
