package com.mayran.dao;

import com.mayran.models.pessoas.Cliente;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class ClienteDAO {
    private File arquivo;

    public ClienteDAO() {
        arquivo = new File("Clientes.txt");
        if (!arquivo.exists()){
            try {
                arquivo.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Set<Cliente> getClientes() {
        Set<Cliente> clientes = new HashSet<>();
        if (arquivo.length() == 0) {
            return clientes;
        }

        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(arquivo))) {
            clientes = (Set<Cliente>) in.readObject();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return clientes;
    }

    private void atualizarArquivo(Set<Cliente> clientes) {
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(arquivo))){
            out.writeObject(clientes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Cliente buscarCliente(int id) {
        Set<Cliente> clientes = getClientes();

        for(Cliente clienteAtual : clientes) {
            if (clienteAtual.getId() == id) {
                return clienteAtual;
            }
        }

        return null;
    }

    public boolean adicionarCliente(Cliente cliente) {
        Set<Cliente> clientes = getClientes();

        if (clientes.add(cliente)) {
            atualizarArquivo(clientes);
            return true;
        }

        return false;
    }

    public boolean atualizarCliente(int id, Cliente cliente) {
        Set<Cliente> clientes = getClientes();

        Cliente clienteParaRemover = null;

        for (Cliente clienteAtual : clientes) {
            if (clienteAtual.getId() == id) {
                clienteParaRemover = clienteAtual;
                break;
            }
        }

        if (clienteParaRemover != null) {
            clientes.remove(clienteParaRemover);
            clientes.add(cliente);
            atualizarArquivo(clientes);
            return true;
        }

        return false;
    }

    public boolean deletarCliente(int id) {
        Set<Cliente> clientes = getClientes();

        Cliente clienteParaRemover = null;

        for (Cliente clienteAtual : clientes) {
            if (clienteAtual.getId() == id) {
                clienteParaRemover = clienteAtual;
                break;
            }
        }

        if (clienteParaRemover != null) {
            clientes.remove(clienteParaRemover);
            atualizarArquivo(clientes);
            return true;
        }
        return false;
    }
}
