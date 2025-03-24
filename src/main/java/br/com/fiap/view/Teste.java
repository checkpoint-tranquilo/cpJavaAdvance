package br.com.fiap.view;

import br.com.fiap.dao.funcionario.FuncionarioDao;
import br.com.fiap.dao.funcionario.FuncionarioDaoImpl;
import br.com.fiap.entity.Funcionario;
import br.com.fiap.exceptions.IdNaoEncontradoException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Teste {
    public static void main(String[] args) {

        //Cria a fábrica
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");

        //Criar o Entity manager
        EntityManager em = fabrica.createEntityManager();

        //Instanciando o DAO
        FuncionarioDao dao = new FuncionarioDaoImpl(em);

        //Cadastrar um funcionario
        Funcionario funcionario = new Funcionario("Fernando", 60.00, 60);
        funcionario.calcularSalario();
        //Mostrando os dados
        System.out.println(funcionario);

        try {
            dao.cadastrar(funcionario);
            dao.commit();
            System.out.println("Funcionário cadastrado.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //Pesquisar funcionarios
        try {
            Funcionario busca = dao.buscarPorId(1L);
            System.out.println(busca.getNome());
        } catch (IdNaoEncontradoException e) {
            System.out.println(e.getMessage());
        }

        //Atualizar um funcionário
        try {
            funcionario.setNome("Laura");
            dao.atualizar(funcionario);
            dao.commit();
            System.out.println("Funcionario atualizado");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        //Corrigir erro no DELETE
        //Remover um Funcionario
        try {
            dao.remover(1L);
            dao.commit();
            System.out.println("Funcionario removido!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}