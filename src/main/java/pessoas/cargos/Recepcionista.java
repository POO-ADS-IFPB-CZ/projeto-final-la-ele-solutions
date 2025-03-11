package pessoas.cargos;

import Model.Empresa;
import Model.Tratamento;
import pessoas.Funcionario;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Recepcionista extends Funcionario {
    public Recepcionista(String cpf, String nome, char genero, String telefone, String email, LocalDate dataContratacao, int cargHoraria, BigDecimal salario, String status) {
        super(cpf, nome, genero, telefone, email, dataContratacao, "Recepcionista", cargHoraria, salario, status);
    }

    public void adicionarTratamento(Empresa empresa, Tratamento tratamento) {
        empresa.adicionarTratamento(tratamento);
    }

    public void removerTratamento(Empresa empresa, Tratamento tratamento) {
        empresa.removerTratamento(tratamento);
    }
}
