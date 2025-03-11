package pessoas.cargos;

import pessoas.Funcionario;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Dentista extends Funcionario {
    public Dentista(String cpf, String nome, char genero, String telefone, String email, LocalDate dataContratacao, int cargHoraria, BigDecimal salario, String status) {
        super(cpf, nome, genero, telefone, email, dataContratacao, "Dentista", cargHoraria, salario, status);
    }

}