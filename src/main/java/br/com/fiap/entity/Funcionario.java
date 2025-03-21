package br.com.fiap.entity;

import br.com.fiap.annotations.Coluna;
import br.com.fiap.annotations.Tabela;

import javax.persistence.*;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Entity
@Tabela(nome = "TAB_FUNCIONARIO")
@Table(name = "TAB_FUNCIONARIO")
@SequenceGenerator(name = "funcionario", sequenceName = "SQ_TAB_FUNCIONARIO", allocationSize = 1)
public class Funcionario {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "funcionario")
    @Coluna(nome = "id")
    private Long id;

    @Coluna(nome = "nome", obrigatorio = true, tamanho = 100)
    @Column(nullable = false, length = 100)
    private String nome;

    @Coluna(nome = "salario", obrigatorio = true)
    @Column(nullable = false)
    private double salario;

    @Coluna(nome = "hr_trabalhadas", obrigatorio = true)
    @Column(name = "hr_trabalhadas", nullable = false)
    private int horasTrabalhadas;

    @Override
    public String toString() {
        return "[Nome: " + nome +
                ", Salário: " + salario +
                ", Horas trabalhadas: " + horasTrabalhadas + "]";
    }

    public Funcionario(String nome, double salario, int horasTrabalhadas) {
        this.nome = nome;
        this.salario = salario;
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas(int horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public void calcularSalario(){
        double salarioFinal = horasTrabalhadas * salario;
        System.out.println("O salário total: " + salarioFinal + "R$");
    }

}
