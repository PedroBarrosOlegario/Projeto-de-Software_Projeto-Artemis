import { createClient } from '@supabase/supabase-js';

const supabaseUrl = import.meta.env.VITE_SUPABASE_URL;
const supabaseAnonKey = import.meta.env.VITE_SUPABASE_SUPABASE_ANON_KEY;

if (!supabaseUrl || !supabaseAnonKey) {
  throw new Error('Missing Supabase environment variables');
}

export const supabase = createClient(supabaseUrl, supabaseAnonKey);

export type UserType = 'student' | 'professor';

export interface Profile {
  id: string;
  user_type: UserType;
  full_name: string;
  email: string;
  created_at: string;
  updated_at: string;
}

export interface Student {
  id: string;
  registration_number: string;
  cpf: string;
  birth_date?: string;
  gender?: string;
  course?: string;
  identity_card?: string;
  nationality?: string;
  place_of_birth?: string;
  military_certificate?: string;
  address?: string;
  phone?: string;
}

export interface Professor {
  id: string;
  registration_number: string;
  cpf: string;
  birth_date?: string;
  gender?: string;
  department?: string;
  identity_card?: string;
  nationality?: string;
  place_of_birth?: string;
  military_certificate?: string;
  address?: string;
  phone?: string;
}
