package br.com.fiap.entity;

public class FuncionarioEspecialista extends Funcionario {

    public FuncionarioEspecialista(String nome, double salario, int horasTrabalhadas) {
        super(nome, salario, horasTrabalhadas);
    }

    @Override
    public void calcularSalario() {
        int bonus = getHorasTrabalhadas() / 15;
        double bonusFixo = 2000 * bonus;
        double salarioFinal = (getSalario() * getHorasTrabalhadas()) + bonusFixo;

        System.out.println(salarioFinal);
    }
}
