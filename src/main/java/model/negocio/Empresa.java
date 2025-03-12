package model.negocio;

import model.pessoa.Cliente;
import model.pessoa.Funcionario;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

public class Empresa implements Serializable {
    private static final long serialVersionUID = 1L;
    private String CNPJ;
    private String nome;
    private List<Funcionario> funcionarios;
    private List<Cliente> clientes;
    private List<Tratamento> tratamentos;

    public Empresa(String CNPJ, String nome) {
        this.CNPJ = CNPJ;
        this.nome = nome;
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

    public void adicionarFuncionarioPorNome(String nome, Funcionario funcionario) {
        if (nome != null && funcionario != null && funcionario.getNome().equals(nome)) {
            adicionarFuncionario(funcionario);
        }
    }

    public Funcionario buscarFuncionarioPorNome(String nome) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getNome().equals(nome)) {
                return funcionario;
            }
        }
        return null;
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

    public String getCNPJ() {
        return CNPJ;
    }
}
