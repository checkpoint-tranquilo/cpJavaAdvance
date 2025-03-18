package br.com.fiap.entity;

public class FuncionarioSenior extends Funcionario{


    public FuncionarioSenior(String nome, double salario, int horasTrabalhadas) {
        super(nome, salario, horasTrabalhadas);
    }
    @Override
    public void calcularSalario(){
            int bonus = getHorasTrabalhadas() / 15;
            double bonusFixo = 1500 * bonus;


            double salarioFinal = (getSalario() * getHorasTrabalhadas()) + bonusFixo;
            System.out.println(salarioFinal);

    }


}
