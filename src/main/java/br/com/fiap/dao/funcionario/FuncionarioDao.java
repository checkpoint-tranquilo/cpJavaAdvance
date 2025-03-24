package br.com.fiap.dao.funcionario;

import br.com.fiap.entity.Funcionario;
import br.com.fiap.exceptions.CommitException;
import br.com.fiap.exceptions.IdNaoEncontradoException;

public interface FuncionarioDao {

    void cadastrar(Funcionario funcionario) throws IllegalAccessException;

    void atualizar(Funcionario funcionario) throws IdNaoEncontradoException, IllegalAccessException;

    Funcionario buscarPorId(Long id) throws IdNaoEncontradoException;

    void remover(Long id) throws IdNaoEncontradoException, IllegalAccessException;

    void commit() throws CommitException;
}
