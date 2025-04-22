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

## Relação das classes
![image](https://github.com/user-attachments/assets/ffdf8c48-d5a9-498d-a3ea-d84a50810bd4)


## Exemplificações Funcionalidades

### Anotações das classes
Todas as classes foram anotadas utilizando anotações JPA para mapear as classes para tabelas no banco de dados Oracle, mais especificamente as duas utilizadas para mapeamento foram as classes de Funcionario e de Gerente
![image](https://github.com/user-attachments/assets/c5dc185e-e3c3-4c1b-b992-ef6b33ac5fb5)

Como é possível observar esta classe está mapeada de forma em que se possa ajustar a tabela do Banco baseada na mesma, elatambém possui anotações personalizadas como a @Tabela e @Coluna que servem para a funcionalidade de ***Gerador de SQL*** onde o mesmo a partir dessas anotações gera um comando SQL na saída do terminal para indicar o que está fazendo, isso será visto mais a frente.
![image (1)](https://github.com/user-attachments/assets/b3e314ba-515f-4539-bdd0-758eb7a60281)

Esta é a classe geradora de SQL, ela é responsável por resgatar as classes anotadas com as anotações personalizadas anteriormente citadas e gerar um texto com o comando SQL utilizado para a operação.

### Respostas dos métodos

#### Dao Insert
Para demonstração será utilizado as duas classes mapeadas para demonstrar como funciona todo o processamento e as respostas dadas.

Primeiramente com o Insert foi feito um método simples capaz de inserir uma entidade no banco de dados
![image](https://github.com/user-attachments/assets/df05b7df-63b1-4947-8b13-d19fb7a0494d)
Como é possível observar o método faz a persistência de um Funcionário assim o adicionando ao banco de dados e logo após ele gera um SQL com os dados inseridos para mostrar ao usuário o que está acontecendo por "debaixo dos panos".
![image](https://github.com/user-attachments/assets/46ae758c-33a7-4044-899a-df968e396a9e)
É aqui onde o teste é realizado, ele tenta fazer a inserção e caso não consiga ele gera uma mensagem de erro ao usuário.

![image](https://github.com/user-attachments/assets/882e3e51-5412-4c54-b49b-dced0be73d26)
![image](https://github.com/user-attachments/assets/f069f143-b6d6-44a8-88c5-61f3dbffb60c)

Nessas duas imagens é possível ver como funcionam os métodos de Calcular Salário e de exibir informações além de mostrar a resposta do que foi cadastrado no banco de dados.

![image](https://github.com/user-attachments/assets/ec16f959-7e0a-4010-a36e-b04831ded6e7)

#### Dao Select
Assim como o Insert este também tem um método no gerador que exibe o comando utilizado pelo banco de dados para realizar a busca por Id do funcionário

![image](https://github.com/user-attachments/assets/552d57f6-8573-4c89-aaf4-3afb1794c1c2)

Neste método ele realiza a busca e logo após verifica se o objeto criado veio vazio, ou seja, não encontrou uma entidade com o id entregue, e caso ele encontre ele imrime o comando SQL específico juntamente da entidade encontrada.

![image](https://github.com/user-attachments/assets/9395deed-b0c7-457a-93a2-b2f37783a74d)

Aqui é possível verificar como é feita a busca, onde é inserido um id e o sistema caso encontre devolverá o nome do funcionário.

![image](https://github.com/user-attachments/assets/9e759398-d78b-4e04-9d47-49284a2992cd)

#### Dao Update
Este método assim como todos os outros também possui um gerador, ele primeiramente pesquisa um Funcionário pelo id e logo após o usuário pode fazer atualziações e depois realizar um merge concluindo assim a atualização e devolvendo o SQL de resposta.

![image](https://github.com/user-attachments/assets/19617ea7-1703-4a0f-a076-e9ca955ac2fb)

Já na classe de teste é possível ver que ele já coleta a entidade utilizada anteriormente para cadastrar e atualiza o nome do mesmo antes de o reenviar para o banco de dados com a atualização já realizada.

![image](https://github.com/user-attachments/assets/1380a1bf-859b-4385-aae8-714ee08223f9)

E como mencionado anteriormente ele realiza primeiro a busca e depois atualiza com as novas informações.

![image](https://github.com/user-attachments/assets/383d732c-5801-4308-8896-6d5443e38931)

#### Dao Delete
E por último o Delete que deleta uma linha do banco de dados pelo id fonecido, assim como o update ele primeiro realiza uma pesquisa para depois deletar a entidade do Banco de dados, para este teste usaremos a classe de Gerente:

![image](https://github.com/user-attachments/assets/98f31e26-b94e-4662-b060-baebb44290b3)

Como é possível ver ele primeiramente realiza a pesquisa para encontrar o Gerente do Id inserido e depois caso encontre ele o deleta.

![image](https://github.com/user-attachments/assets/8001edea-4e34-4d7e-a1ba-95bd9386c48e)

Na classe de teste ele realiza o método e caso corra tudo de acordo ele realizará o commit salvando assim as alterações feitas e caso houver um erro ele dará a mensagem de erro para o usuário, e logo após isso ele fechará a fábrica de entidades e a persistências.

![image](https://github.com/user-attachments/assets/e5ac6b35-49c9-41ec-b520-0008d6d7d0f3)

E esta é a resposta entregue pelo terminal para que o usuário saiba o que foi realizado :).


## Como Usar

1. **Configurar do Banco de Dados:**
A configuração do banco de dados deve ser feita no arquivo `persistence.xml`;

2. **Cadastrar funcionários:**
Para cadastrar um novo funcionário é só instanciar a classe `Funcionario`, preencher os campos e chamar o método `cadastrar()` do DAO desejado;

3. **Calcular salário:**
Cada tipo de funcionário (como `FuncionarioEspecialista`, `FuncionarioJunior`, etc.) tem um método específico para calcular o salário com base nas horas trabalhadas;
