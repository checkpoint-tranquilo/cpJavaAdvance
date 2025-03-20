package br.com.fiap.entity;

public class FuncionarioPleno extends Funcionario {

    public FuncionarioPleno(String nome, double salario, int horasTrabalhadas) {
        super(nome, salario, horasTrabalhadas);
    }

    @Override
    public void calcularSalario() {
        double salarioFinal = getSalario() * getHorasTrabalhadas();
        salarioFinal += salarioFinal * 0.10;

        System.out.println(salarioFinal);
    }
}
