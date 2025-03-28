# Checkpoint 1 | Java (2TDSPY)

Este projeto é um sistema de gestão de funcionários que utiliza anotações personalizadas, herança de classes e um gerador de SQL para facilitar a manipulação de dados em um banco de dados.

## Membros

- Wesley Sena | RM: 558043
- Vanessa Yukari | RM: 558092
- Samara Victoria | RM: 558719
- Vinicius Murtinho | RM: 551151

## Funcionalidades

- **Gerador SQL:** Um gerador dinâmico de SQL que cria comandos `SELECT`, `INSERT`, `UPDATE` e `DELETE` com base nas anotações personalizadas nas classes (`Funcionario` e `Gerente`). Ele utiliza reflexão para mapear os campos das classes para gerar as instruções SQL de forma automatizada;
  
- **Anotações Personalizadas:** O sistema utiliza anotações personalizadas como `@Tabela` e `@Coluna` pra mapear as entidades Java para tabelas e colunas no banco de dados. Isso permite um controle mais flexível e dinâmico da criação das instruções SQL;

- **Herança de Tabelas:** As classes de funcionários, como `FuncionarioEspecialista`, `FuncionarioEstagiario`, `FuncionarioJunior`, `FuncionarioPleno`, e `FuncionarioSenior` estendem a classe `Funcionario` e compartilham atributos e métodos. A estratégia de herança `TABLE_PER_CLASS` é usada para mapear as subclasses para tabelas no banco de dados;

## Estrutura de Arquivos

### 1. **Anotações**
- **`@Coluna`**
- **`@Tabela`**

### 2. **DAO**
implementação dos padrões DAO para gerenciar as operações de banco de dados. Cada entidade (`Funcionario`, `Gerente`, etc.) tem seu respectivo DAO com métodos para cadastrar, atualizar, buscar e remover registros no banco de dados.

### 3. **Gerador de SQL**
O `SqlGenerator` é uma classe que usa reflexão para gerar comandos SQL automaticamente com base nas anotações. 

### 4. **Entidades**
As entidades representam os funcionários e seus tipos, como `Funcionario`, `Gerente`, `FuncionarioEspecialista`, `FuncionarioEstagiario`, entre outros. Cada uma dessas classes tem campos com anotações `@Coluna` para mapear pro banco de dados.

### 5. **Exceções**
- **`CommitException`**
- **`IdNaoEncontradoException`**

## Como Usar

1. **Configurar do Banco de Dados:**
A configuração do banco de dados deve ser feita no arquivo `persistence.xml`;

2. **Cadastrar funcionários:**
Para cadastrar um novo funcionário é só instanciar a classe `Funcionario`, preencher os campos e chamar o método `cadastrar()` do DAO desejado;

3. **Calcular salário:**
Cada tipo de funcionário (como `FuncionarioEspecialista`, `FuncionarioJunior`, etc.) tem um método específico para calcular o salário com base nas horas trabalhadas;
