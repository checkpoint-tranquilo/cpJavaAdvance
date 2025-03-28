package br.com.fiap.view;

import br.com.fiap.dao.gerente.GerenteDaoImpl;
import br.com.fiap.dao.gerente.GerenteDao;
import br.com.fiap.entity.Gerente;
import br.com.fiap.entity.enums.Setor;
import br.com.fiap.exceptions.IdNaoEncontradoException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

class TesteGerente {
    public static void main(String[] args) {

        // Cria a fábrica
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");

        // Criar o EntityManager
        EntityManager em = fabrica.createEntityManager();

        // Instanciando o DAO
        GerenteDao dao = new GerenteDaoImpl(em);

        // Cadastrar um gerente
        Gerente gerente = new Gerente("Melissa", 15.00, 10, Setor.VENDAS);
        gerente.calcularSalario();
        System.out.println(gerente);

        try {
            dao.cadastrar(gerente);
            dao.commit();
            System.out.println("Gerente cadastrado.");
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar gerente: " + e.getMessage());
        }

        // Pesquisar gerente
        try {
            Gerente busca = dao.buscarPorId(25L);
            System.out.println("Nome do gerente encontrado: " + busca.getNome());
        } catch (IdNaoEncontradoException e) {
            System.out.println("Erro ao buscar gerente: " + e.getMessage());
        }

        // Atualizar um gerente
        try {
            gerente.setNome("Mariana");
            dao.atualizar(gerente);
            dao.commit();
            System.out.println("Gerente atualizado.");
        } catch (Exception e) {
            System.out.println("Erro ao atualizar gerente: " + e.getMessage());
        }

        // Remover um gerente
        try {
            dao.remover(24L);
            dao.commit();
            System.out.println("Gerente removido!");
        } catch (Exception e) {
            System.out.println("Erro ao remover gerente: " + e.getMessage());
        } finally {
            // Fechar o EntityManager e a fábrica de persistência
            em.close();
            fabrica.close();
        }
    }
}

