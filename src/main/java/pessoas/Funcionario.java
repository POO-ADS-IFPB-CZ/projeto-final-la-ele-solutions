package pessoas;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Funcionario extends Pessoa{
    private LocalDate dataContratacao;
    private String cargo;
    private int cargHoraria;
    private BigDecimal salario;
    private String status;

    public Funcionario(String cpf, String nome, char genero, String telefone, String email, LocalDate dataContratacao, String cargo, int cargHoraria, BigDecimal salario, String status) {
        super(cpf, nome, genero, telefone, email);
        this.dataContratacao = dataContratacao;
        this.cargo = cargo;
        this.cargHoraria = cargHoraria;
        this.salario = salario;
        this.status = status;
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