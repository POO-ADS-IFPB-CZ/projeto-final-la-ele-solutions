package pessoas.cargos;

import Model.Empresa;
import pessoas.Funcionario;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Administrador extends Funcionario {
    public Administrador(String cpf, String nome, char genero, String telefone, String email, LocalDate dataContratacao, int cargHoraria, BigDecimal salario, String status) {
        super(cpf, nome, genero, telefone, email, dataContratacao, "Administrador", cargHoraria, salario, status);
    }

    public void adicionarFuncionario(Empresa empresa, Funcionario funcionario) {
        empresa.adicionarFuncionario(funcionario);
    }

    public void removerFuncionario(Empresa empresa, Funcionario funcionario) {
        empresa.removerFuncionario(funcionario);
    }
}
