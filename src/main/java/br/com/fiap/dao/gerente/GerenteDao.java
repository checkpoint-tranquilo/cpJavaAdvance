package br.com.fiap.dao.gerente;

import br.com.fiap.entity.Gerente;
import br.com.fiap.exceptions.CommitException;
import br.com.fiap.exceptions.IdNaoEncontradoException;
public interface GerenteDao {

    void cadastrar(Gerente gerente) throws IllegalAccessException;

    void atualizar(Gerente gerente) throws IdNaoEncontradoException, IllegalAccessException;

    Gerente buscarPorId(Long id) throws IdNaoEncontradoException;

    void remover(Long id) throws IdNaoEncontradoException, IllegalAccessException;

    void commit() throws CommitException;
}
