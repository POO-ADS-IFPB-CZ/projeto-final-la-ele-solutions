package com.mayran.models.pessoas;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Funcionario extends Pessoa {
    private int id;
    private LocalDate dataContratacao;
    private String cargo;
    private int cargHoraria;
    private BigDecimal salario;
    private String status;
    private String cargoFuncionario;
    private static int contadorId = 1;

    public Funcionario(String cpf, String nome, char genero, String telefone, String email, LocalDate dataContratacao,
                       String cargo, int cargHoraria, BigDecimal salario, String status, String cargoFuncionario) {
        super(cpf, nome, genero, telefone, email);
        this.dataContratacao = dataContratacao;
        this.cargo = cargo;
        this.cargHoraria = cargHoraria;
        this.salario = salario;
        this.status = status;
        this.cargoFuncionario = cargoFuncionario;
        this.id = contadorId++;
    }

    public LocalDate getDataContratacao() {
        return dataContratacao;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getCargHoraria() {
        return cargHoraria;
    }

    public void setCargHoraria(int cargHoraria) {
        this.cargHoraria = cargHoraria;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    //TODO: fazer uma regra de negócios aq
    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDataContratacao(LocalDate dataContratacao) {
        this.dataContratacao = dataContratacao;
    }

    public String getCargoFuncionario() {
        return cargoFuncionario;
    }

    public void setCargoFuncionario(String cargoFuncionario) {
        this.cargoFuncionario = cargoFuncionario;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format(
                "Funcionário:\n" +
                        "  Nome: %s\n" +
                        "  CPF: %s\n" +
                        "  Gênero: %c\n" +
                        "  Telefone: %s\n" +
                        "  Email: %s\n" +
                        "  Data de Contratação: %s\n" +
                        "  Cargo: %s\n" +
                        "  Carga Horária: %d horas\n" +
                        "  Salário: R$ %.2f\n" +
                        "  Status: %s",
                super.getNome(), super.getCpf(), super.getGenero(),
                super.getTelefone(), super.getEmail(),
                dataContratacao, cargo, cargHoraria, salario, status
        );
    }
}