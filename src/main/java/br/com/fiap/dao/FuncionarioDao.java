package br.com.fiap.dao;

import br.com.fiap.entity.Funcionario;
import br.com.fiap.exceptions.CommitException;
import br.com.fiap.exceptions.IdNaoEncontradoException;

import java.util.List;

public interface FuncionarioDao {

    void cadastrar(Funcionario funcionario) throws IllegalAccessException;

    void atualizar(Funcionario funcionario) throws IdNaoEncontradoException, IllegalAccessException;

    List<Funcionario> buscarFuncionarios();

    Funcionario buscarPorId(Long id) throws IdNaoEncontradoException;

    void remover(Long id) throws IdNaoEncontradoException, IllegalAccessException;

    void commit() throws CommitException;
}
