package br.com.fiap.entity;

public class FuncionarioEstagiario extends Funcionario {

    public FuncionarioEstagiario(String nome, double salario, int horasTrabalhadas) {
        super(nome, salario, horasTrabalhadas);
    }

    @Override
    public void calcularSalario() {
        double salarioFinal = getSalario() * getHorasTrabalhadas();

        System.out.println(salarioFinal);
    }
}
