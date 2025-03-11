package Model;

import pessoas.Cliente;
import pessoas.Funcionario;
import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private static int contadorId = 1;
    private int id;
    private List<Funcionario> funcionarios;
    private List<Cliente> clientes;
    private List<Tratamento> tratamentos;

    public Empresa() {
        this.funcionarios = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.tratamentos = new ArrayList<>();
    }

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

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void removerCliente(Cliente cliente) {
        clientes.remove(cliente);
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public int getId() {
        return id;
    }
}

