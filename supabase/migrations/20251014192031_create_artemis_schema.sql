/*
  # Create Artemis University System Schema

  1. New Tables
    - `profiles`
      - `id` (uuid, primary key, references auth.users)
      - `user_type` (text, either 'student' or 'professor')
      - `full_name` (text)
      - `email` (text)
      - `created_at` (timestamptz)
      - `updated_at` (timestamptz)
    
    - `students`
      - `id` (uuid, primary key, references profiles)
      - `registration_number` (text, unique)
      - `cpf` (text, unique)
      - `birth_date` (date)
      - `gender` (text)
      - `course` (text)
      - `identity_card` (text)
      - `nationality` (text)
      - `place_of_birth` (text)
      - `military_certificate` (text)
      - `address` (text)
      - `phone` (text)
      - `created_at` (timestamptz)
    
    - `professors`
      - `id` (uuid, primary key, references profiles)
      - `registration_number` (text, unique)
      - `cpf` (text, unique)
      - `birth_date` (date)
      - `gender` (text)
      - `department` (text)
      - `identity_card` (text)
      - `nationality` (text)
      - `place_of_birth` (text)
      - `military_certificate` (text)
      - `address` (text)
      - `phone` (text)
      - `created_at` (timestamptz)

  2. Security
    - Enable RLS on all tables
    - Add policies for authenticated users to read and update their own data
    - Add policies for role-based access control
*/

-- Create profiles table
CREATE TABLE IF NOT EXISTS profiles (
  id uuid PRIMARY KEY REFERENCES auth.users ON DELETE CASCADE,
  user_type text NOT NULL CHECK (user_type IN ('student', 'professor')),
  full_name text NOT NULL,
  email text NOT NULL,
  created_at timestamptz DEFAULT now(),
  updated_at timestamptz DEFAULT now()
);

ALTER TABLE profiles ENABLE ROW LEVEL SECURITY;

-- Create students table
CREATE TABLE IF NOT EXISTS students (
  id uuid PRIMARY KEY REFERENCES profiles ON DELETE CASCADE,
  registration_number text UNIQUE NOT NULL,
  cpf text UNIQUE NOT NULL,
  birth_date date,
  gender text,
  course text,
  identity_card text,
  nationality text DEFAULT 'Brasileiro',
  place_of_birth text,
  military_certificate text,
  address text,
  phone text,
  created_at timestamptz DEFAULT now()
);

ALTER TABLE students ENABLE ROW LEVEL SECURITY;

-- Create professors table
CREATE TABLE IF NOT EXISTS professors (
  id uuid PRIMARY KEY REFERENCES profiles ON DELETE CASCADE,
  registration_number text UNIQUE NOT NULL,
  cpf text UNIQUE NOT NULL,
  birth_date date,
  gender text,
  department text,
  identity_card text,
  nationality text DEFAULT 'Brasileiro',
  place_of_birth text,
  military_certificate text,
  address text,
  phone text,
  created_at timestamptz DEFAULT now()
);

ALTER TABLE professors ENABLE ROW LEVEL SECURITY;

-- Profiles policies
CREATE POLICY "Users can view own profile"
  ON profiles FOR SELECT
  TO authenticated
  USING (auth.uid() = id);

CREATE POLICY "Users can update own profile"
  ON profiles FOR UPDATE
  TO authenticated
  USING (auth.uid() = id)
  WITH CHECK (auth.uid() = id);

CREATE POLICY "Users can insert own profile"
  ON profiles FOR INSERT
  TO authenticated
  WITH CHECK (auth.uid() = id);

-- Students policies
CREATE POLICY "Students can view own data"
  ON students FOR SELECT
  TO authenticated
  USING (auth.uid() = id);

CREATE POLICY "Students can update own data"
  ON students FOR UPDATE
  TO authenticated
  USING (auth.uid() = id)
  WITH CHECK (auth.uid() = id);

CREATE POLICY "Students can insert own data"
  ON students FOR INSERT
  TO authenticated
  WITH CHECK (auth.uid() = id);

-- Professors policies
CREATE POLICY "Professors can view own data"
  ON professors FOR SELECT
  TO authenticated
  USING (auth.uid() = id);

CREATE POLICY "Professors can update own data"
  ON professors FOR UPDATE
  TO authenticated
  USING (auth.uid() = id)
  WITH CHECK (auth.uid() = id);

CREATE POLICY "Professors can insert own data"
  ON professors FOR INSERT
  TO authenticated
  WITH CHECK (auth.uid() = id);

-- Create function to update updated_at timestamp
CREATE OR REPLACE FUNCTION update_updated_at_column()
RETURNS TRIGGER AS $$
BEGIN
  NEW.updated_at = now();
  RETURN NEW;
END;
$$ LANGUAGE plpgsql;

-- Create trigger for profiles
DROP TRIGGER IF EXISTS update_profiles_updated_at ON profiles;
CREATE TRIGGER update_profiles_updated_at
  BEFORE UPDATE ON profiles
  FOR EACH ROW
  EXECUTE FUNCTION update_updated_at_column();