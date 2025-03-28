package br.com.fiap.dao.gerente;

import br.com.fiap.entity.Gerente;
import br.com.fiap.exceptions.CommitException;
import br.com.fiap.exceptions.IdNaoEncontradoException;
import br.com.fiap.generator.SqlGenerator;

import javax.persistence.EntityManager;
public class GerenteDaoImpl implements GerenteDao {

    private EntityManager em;

    public GerenteDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public void cadastrar(Gerente gerente) {
        em.persist(gerente);
    }

    @Override
    public void atualizar(Gerente gerente) throws IdNaoEncontradoException{
        buscarPorId(gerente.getId());
        em.merge(gerente);
    }

    @Override
    public Gerente buscarPorId(Long id) throws IdNaoEncontradoException {
        Gerente gerente = em.find(Gerente.class, id);

        if (gerente == null) {
            System.out.println("Gerente não encontrado");
        }

        return gerente;
    }

    @Override
    public void remover(Long id) throws IdNaoEncontradoException, IllegalAccessException {
        Gerente gerente = buscarPorId(id);
        em.remove(gerente);
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
