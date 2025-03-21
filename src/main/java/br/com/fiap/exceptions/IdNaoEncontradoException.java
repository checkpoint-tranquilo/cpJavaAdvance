package br.com.fiap.exceptions;

public class IdNaoEncontradoException extends Exception {

    public IdNaoEncontradoException(String mensagem){
        super(mensagem);
    }

    public IdNaoEncontradoException(){
        super("Entidade não encontrada.");
    }
}