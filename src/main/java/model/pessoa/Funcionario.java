package model.pessoa;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

public class Funcionario extends Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;
    private final LocalDate dataContratacao;
    private String cargo;
    private int cargaHoraria;
    private BigDecimal salario;
    private String status;

    public Funcionario(String cpf, String nome, char genero, String telefone, String email, LocalDate dataContratacao, String cargo, int cargaHoraria, BigDecimal salario, String status) {
        super(cpf, nome, genero, telefone, email);
        if (dataContratacao == null) throw new IllegalArgumentException("Data de contratação não pode ser nula");
        if (cargaHoraria < 0 || cargaHoraria > 44) throw new IllegalArgumentException("Carga horária deve ser entre 0 e 44 horas");
        if (status == null || status.trim().isEmpty()) throw new IllegalArgumentException("Status não pode ser nulo ou vazio");

        this.dataContratacao = dataContratacao;
        this.cargo = cargo;
        this.cargaHoraria = cargaHoraria;
        this.salario = salario;
        this.status = status;
    }

    public LocalDate getDataContratacao() {
        return dataContratacao;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        if (cargo != null && !cargo.trim().isEmpty()) {
            this.cargo = cargo;
        }
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        if (cargaHoraria >= 0 && cargaHoraria <= 44) {
            this.cargaHoraria = cargaHoraria;
        }
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        if (salario != null && salario.compareTo(BigDecimal.ZERO) > 0) {
            this.salario = salario;
        }
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        if (status != null && !status.trim().isEmpty()) {
            this.status = status;
        }
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
                dataContratacao, cargo, cargaHoraria, salario, status
        );
    }
}
