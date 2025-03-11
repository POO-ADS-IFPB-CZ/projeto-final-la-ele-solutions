package Model;

import pessoas.Cliente;
import pessoas.Funcionario;

import java.util.List;

public class Empresa {
    private List<Funcionario> funcionarios;
    private List<Cliente> clientes;
    private List<Tratamento> tratamentos;

    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public void removerFuncionario(Funcionario funcionario) {
        funcionarios.remove(funcionario);
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void adicionarTratamento(Tratamento tratamento) {
        tratamentos.add(tratamento);
    }

    public void removerTratamento(Tratamento tratamento) {
        tratamentos.remove(tratamento);
    }

    public List<Tratamento> getTratamentos() {
        return tratamentos;
    }
}
