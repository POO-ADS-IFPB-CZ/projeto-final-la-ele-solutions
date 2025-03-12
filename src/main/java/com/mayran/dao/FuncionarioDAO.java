package com.mayran.dao;

import com.mayran.models.pessoas.Funcionario;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class FuncionarioDAO {
    private File arquivo;

    public FuncionarioDAO() {
        arquivo = new File("Funcionarios.txt");
        if (!arquivo.exists()){
            try {
                arquivo.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Set<Funcionario> getFuncionarios() {
        Set<Funcionario> funcionarios = new HashSet<>();
        if (arquivo.length() == 0) {
            return funcionarios;
        }

        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(arquivo))) {
            funcionarios = (Set<Funcionario>) in.readObject();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return funcionarios;
    }

    private void atualizarArquivo(Set<Funcionario> funcionarios) {
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(arquivo))){
            out.writeObject(funcionarios);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Funcionario buscarFuncionario(int id) {
        Set<Funcionario> funcionarios = getFuncionarios();

        for(Funcionario funcionarioAtual : funcionarios) {
            if (funcionarioAtual.getId() == id) {
                return funcionarioAtual;
            }
        }

        return null;
    }

    public boolean adicionarFuncionario(Funcionario funcionario) {
        Set<Funcionario> funcionarios = getFuncionarios();

        if (funcionarios.add(funcionario)) {
            atualizarArquivo(funcionarios);
            return true;
        }

        return false;
    }

    public boolean atualizarFuncionario(int id, Funcionario funcionario) {
        Set<Funcionario> funcionarios = getFuncionarios();

        Funcionario funcionarioParaRemover = null;

        for (Funcionario funcionarioAtual : funcionarios) {
            if (funcionarioAtual.getId() == id) {
                funcionarioParaRemover = funcionarioAtual;
                break;
            }
        }

        if (funcionarioParaRemover != null) {
            funcionarios.remove(funcionarioParaRemover);
            funcionarios.add(funcionario);
            atualizarArquivo(funcionarios);
            return true;
        }

        return false;
    }

    public boolean deletarFuncionario(int id) {
        Set<Funcionario> funcionarios = getFuncionarios();

        Funcionario funcionarioParaRemover = null;

        for (Funcionario funcionarioAtual : funcionarios) {
            if (funcionarioAtual.getId() == id) {
                funcionarioParaRemover = funcionarioAtual;
                break;
            }
        }

        if (funcionarioParaRemover != null) {
            funcionarios.remove(funcionarioParaRemover);
            atualizarArquivo(funcionarios);
            return true;
        }
        return false;
    }
}
