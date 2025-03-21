package br.com.fiap.dao;

import br.com.fiap.entity.Funcionario;
import br.com.fiap.exceptions.CommitException;
import br.com.fiap.exceptions.IdNaoEncontradoException;
import br.com.fiap.generator.SqlGenerator;

import javax.persistence.EntityManager;
import java.util.List;

public class FuncionarioDaoImpl implements FuncionarioDao{

    private EntityManager em;

    public FuncionarioDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public void cadastrar(Funcionario funcionario) throws IllegalAccessException {
        em.persist(funcionario);
        System.out.println(SqlGenerator.gerarInsert(funcionario));
    }

    @Override
    public void atualizar(Funcionario funcionario) throws IdNaoEncontradoException, IllegalAccessException {
        buscarPorId(funcionario.getId());
        em.merge(funcionario);
        System.out.println(SqlGenerator.gerarUpdate(funcionario));
    }

    @Override
    public Funcionario buscarPorId(Long id) throws IdNaoEncontradoException {
        Funcionario funcionario = em.find(Funcionario.class, id);

        if (funcionario == null) {
            System.out.println("Funcionario não encontrado");
        }

        return funcionario;
    }

    @Override
    public void remover(Long id) throws IdNaoEncontradoException, IllegalAccessException {
        Funcionario funcionario = buscarPorId(id);
        em.remove(funcionario);
        System.out.println(SqlGenerator.gerarDelete(Funcionario.class));
    }

    @Override
    public void commit() throws CommitException {
        try {
            em.getTransaction().begin();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new CommitException("Não foi possível realizar a operação.");
        }
    }
}
