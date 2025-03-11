package pessoas.cargos;

import Model.Empresa;
import Model.Tratamento;
import pessoas.Cliente;
import pessoas.Funcionario;
import java.math.BigDecimal;
import java.time.LocalDate;

public class Administrador extends Funcionario {
    public Administrador(String cpf, String nome, char genero, String telefone, String email, LocalDate dataContratacao, int cargHoraria, BigDecimal salario, String status) {
        super(cpf, nome, genero, telefone, email, dataContratacao, "Administrador", cargHoraria, salario, status);
    }

    public void adicionarFuncionario(Empresa empresa, Funcionario funcionario) {
        if (empresa == null || funcionario == null)
            return;
        if (!empresa.getFuncionarios().contains(funcionario)) {
            empresa.adicionarFuncionario(funcionario);
        }
    }

    public void removerFuncionario(Empresa empresa, Funcionario funcionario) {
        if (empresa == null || funcionario == null)
            return;
        empresa.removerFuncionario(funcionario);
    }

    public void adicionarCliente(Empresa empresa, Cliente cliente) {
        if (empresa == null || cliente == null)
            return;
        if (!empresa.getClientes().contains(cliente)) {
            empresa.adicionarCliente(cliente);
        }
    }

    public void removerCliente(Empresa empresa, Cliente cliente) {
        if (empresa == null || cliente == null) return;
        empresa.removerCliente(cliente);
    }

    public void adicionarTratamento(Empresa empresa, Tratamento tratamento) {
        if (empresa == null || tratamento == null) return;
        if (!empresa.getTratamentos().contains(tratamento)) {
            empresa.adicionarTratamento(tratamento);
        }
    }

    public void removerTratamento(Empresa empresa, Tratamento tratamento) {
        if (empresa == null || tratamento == null) return;
        empresa.removerTratamento(tratamento);
    }
}
