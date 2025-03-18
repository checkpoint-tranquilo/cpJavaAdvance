package br.com.fiap.entity;

public class Funcionario {

    private String nome;
    private double salario;
    private int horasTrabalhadas;

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

    public Funcionario(String nome, double salario, int horasTrabalhadas) {
        this.nome = nome;
        this.salario = salario;
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public void calcularSalario(){
        double salarioFinal = horasTrabalhadas * salario;
        System.out.println("O salário total: " + salarioFinal);
    }

    @Override
    public String toString() {
        return "[Nome: " + nome +
                ", Salário: " + salario +
                ", Horas trabalhadas: " + horasTrabalhadas + "]";
    }
}
