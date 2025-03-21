package br.com.fiap.entity;

import br.com.fiap.entity.enums.Setor;

public class Gerente extends Funcionario{

    private Setor setor;

    public Gerente(String nome, double salario, int horasTrabalhadas, Setor setor) {
        super(nome, salario, horasTrabalhadas);
        this.setor = setor;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    @Override
    public void calcularSalario(){
        int bonus = (getHorasTrabalhadas() / 15) * 2500;

        double salarioFinal = (getSalario() * getHorasTrabalhadas()) * bonus;

        System.out.println("Salário total: " + salarioFinal + "R$");
    }
}
