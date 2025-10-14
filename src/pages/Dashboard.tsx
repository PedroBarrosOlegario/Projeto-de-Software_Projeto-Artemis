import { Navigate } from 'react-router-dom';
import { useAuth } from '../contexts/AuthContext';
import { StudentDashboard } from './StudentDashboard';
import { ProfessorDashboard } from './ProfessorDashboard';

export function Dashboard() {
  const { profile, loading } = useAuth();

  if (loading) {
    return (
      <div className="min-h-screen bg-gradient-to-br from-slate-50 to-slate-100 flex items-center justify-center">
        <div className="text-center">
          <div className="animate-spin rounded-full h-12 w-12 border-b-2 border-slate-700 mx-auto mb-4"></div>
          <p className="text-slate-600">Carregando...</p>
        </div>
      </div>
    );
  }

  if (!profile) {
    return <Navigate to="/login" replace />;
  }

  return profile.user_type === 'student' ? <StudentDashboard /> : <ProfessorDashboard />;
}
