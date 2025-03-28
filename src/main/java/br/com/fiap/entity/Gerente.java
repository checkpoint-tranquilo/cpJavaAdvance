package br.com.fiap.entity;

import br.com.fiap.annotations.Coluna;
import br.com.fiap.annotations.Tabela;
import br.com.fiap.entity.enums.Setor;

import javax.persistence.*;

@Entity
@Tabela(nome = "TAB_GERENTE")
@Table(name = "TAB_GERENTE")
public class Gerente extends Funcionario{

    @Enumerated(EnumType.STRING)
    @Coluna(nome = "setor", obrigatorio = true)
    @Column(nullable = false)
    private Setor setor;

    public Gerente() {}

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
