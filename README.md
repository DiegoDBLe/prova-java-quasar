# Sistema de Gestão Escolar 📚🧑‍🏫

[![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)](https://www.java.com)
[![License](https://img.shields.io/badge/License-MIT-green?style=for-the-badge)](LICENSE)
[![Status](https://img.shields.io/badge/Status-Completed-blue?style=for-the-badge)](#)
[![Contributions](https://img.shields.io/badge/Contributions-Welcome-orange?style=for-the-badge)](CONTRIBUTING.md)

## 📖 Descrição

Este projeto é um sistema para gerenciar escolas em uma instituição educacional. Ele foi desenvolvido para calcular o menor número possível de professores necessários para atender às turmas, levando em conta as regras específicas de cada tipo de escola (Berçário, Ensino Fundamental e Ensino Médio).

## 🚀 Tecnologias Utilizadas

- **Java**: Linguagem de programação principal.
- **Git**: Controle de versão.
- **IDE**: IntelliJ IDEA.
- **Lombok**: Redução de boilerplate, gerando automaticamente getters, setters e construtores.:

## 🏗 Estrutura do Projeto

### Pacotes
- **model**: Contém as classes principais, como `Aluno`, `Professor`, `Turma`, entre outras.
- **service**: Inclui os serviços responsáveis por lógica de negócios, como `EscolaService`, `TurmaService` e `ProfessorService`.
- **enums**: Enumerações para representar `Escola` e `Turno`.

### Regras por Escola
#### Berçário
- Máximo de 10 crianças por turma.
- Máximo de 5 crianças por professor.
- Turno único: Tarde.

#### Ensino Fundamental
- Máximo de 20 alunos por turma.
- Cada disciplina possui carga horária de 2 horas.
- Turno único: Manhã.

#### Ensino Médio
- Máximo de 30 alunos por turma.
- Cada disciplina possui carga horária de 1 hora.
- Turnos: Manhã e Tarde.

## 📋 Funcionalidades

- **Agrupamento de Alunos**: Divide os alunos em turmas conforme as regras de cada escola.
- **Cálculo de Professores**: Determina o número mínimo de professores necessários.
- **Distribuição de Professores**: Aloca os professores respeitando turnos e disciplinas.

## 🔧 Configuração e Execução

1. Clone o repositório:
   ```bash
   git clone https://github.com/SeuUsuario/SistemaGestaoEscolar.git
