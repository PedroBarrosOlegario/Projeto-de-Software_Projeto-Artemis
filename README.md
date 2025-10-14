# ARTEMIS - Sistema Universitário

Sistema de gestão universitária com portais separados para alunos e professores.

## Funcionalidades

### Portal do Aluno
- Login e cadastro dedicados
- Visualização de disciplinas matriculadas
- Consulta de histórico acadêmico e notas
- Visualização de horários de aula
- Gerenciamento de perfil pessoal
- Avisos e notificações acadêmicas

### Portal do Professor
- Login e cadastro dedicados
- Gerenciamento de turmas e disciplinas
- Criação e edição de planos de ensino
- Registro de notas e frequência dos alunos
- Gerenciamento de perfil pessoal
- Visualização de próximas aulas
- Avisos departamentais

## Tecnologias Utilizadas

- **Frontend**: React 18 + TypeScript + Vite
- **Estilização**: Tailwind CSS
- **Roteamento**: React Router DOM
- **Backend/Database**: Supabase (PostgreSQL)
- **Autenticação**: Supabase Auth

## Estrutura do Projeto

```
src/
├── components/          # Componentes reutilizáveis
│   ├── Logo.tsx        # Logo do sistema
│   └── ProtectedRoute.tsx  # Proteção de rotas
├── contexts/           # Contextos React
│   └── AuthContext.tsx # Contexto de autenticação
├── lib/               # Bibliotecas e configurações
│   └── supabase.ts    # Cliente Supabase
├── pages/             # Páginas da aplicação
│   ├── Login.tsx      # Página de login
│   ├── Register.tsx   # Página de cadastro
│   ├── Dashboard.tsx  # Redirecionador de dashboard
│   ├── StudentDashboard.tsx   # Dashboard do aluno
│   └── ProfessorDashboard.tsx # Dashboard do professor
├── App.tsx            # Componente principal
├── main.tsx          # Ponto de entrada
└── index.css         # Estilos globais
```

## Database Schema

O sistema utiliza Supabase com as seguintes tabelas:

- **profiles**: Informações básicas do usuário e tipo (aluno/professor)
- **students**: Dados específicos dos alunos (matrícula, CPF, curso, etc.)
- **professors**: Dados específicos dos professores (departamento, matrícula, etc.)

Todas as tabelas possuem Row Level Security (RLS) habilitado para garantir a segurança dos dados.

## Como Executar

1. Instale as dependências:
```bash
npm install
```

2. Configure as variáveis de ambiente no arquivo `.env`:
```
VITE_SUPABASE_URL=sua_url_do_supabase
VITE_SUPABASE_SUPABASE_ANON_KEY=sua_chave_anonima
```

3. Execute o projeto em modo de desenvolvimento:
```bash
npm run dev
```

4. Para construir para produção:
```bash
npm run build
```

## Design

O sistema utiliza uma paleta de cores neutra e profissional baseada em tons de cinza (slate), proporcionando:
- Interface limpa e moderna
- Boa legibilidade
- Experiência agradável aos olhos
- Design responsivo para diferentes dispositivos

## Segurança

- Autenticação via Supabase Auth
- Row Level Security (RLS) em todas as tabelas
- Rotas protegidas por tipo de usuário
- Validação de permissões no backend

## Fluxo de Autenticação

1. Usuário acessa a página de login
2. Pode escolher entre criar uma conta (aluno ou professor) ou fazer login
3. Após autenticação, é redirecionado para o dashboard correspondente ao seu tipo
4. Cada portal exibe funcionalidades específicas para o tipo de usuário
