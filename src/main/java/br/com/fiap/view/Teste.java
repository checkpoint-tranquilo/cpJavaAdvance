package br.com.fiap.view;

import br.com.fiap.entity.Funcionario;
import br.com.fiap.entity.FuncionarioSenior;

public class Teste {
    public static void main(String[] args) {
        Funcionario f = new Funcionario("vini", 50,20);
        FuncionarioSenior fs = new FuncionarioSenior("joão", 100, 25);

        f.calcularSalario();
        fs.calcularSalario();
    }
}
