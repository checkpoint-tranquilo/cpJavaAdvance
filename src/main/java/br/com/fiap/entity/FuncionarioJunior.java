package br.com.fiap.entity;

public class FuncionarioJunior extends Funcionario {

    public FuncionarioJunior(String nome, double salario, int horasTrabalhadas) {
        super(nome, salario, horasTrabalhadas);
    }

    @Override
    public void calcularSalario() {
        double salarioFinal = getSalario() * getHorasTrabalhadas();
        salarioFinal += salarioFinal * 0.05;

        System.out.println(salarioFinal);
    }
}
