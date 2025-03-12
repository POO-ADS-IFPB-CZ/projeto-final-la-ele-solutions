package com.mayran.dao;

import com.mayran.models.Consulta;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class ConsultaDAO {
    private File arquivo;

    public ConsultaDAO() {
        arquivo = new File("Consultas.txt");
        if (!arquivo.exists()){
            try {
                arquivo.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Set<Consulta> getConsultas() {
        Set<Consulta> consultas = new HashSet<>();
        if (arquivo.length() == 0) {
            return consultas;
        }

        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(arquivo))) {
            consultas = (Set<Consulta>) in.readObject();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return consultas;
    }

    private void atualizarArquivo(Set<Consulta> consultas) {
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(arquivo))){
            out.writeObject(consultas);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Consulta buscarConsulta(int id) {
        Set<Consulta> consultas = getConsultas();

        for(Consulta consultaAtual : consultas) {
            if (consultaAtual.getId() == id) {
                return consultaAtual;
            }
        }

        return null;
    }

    public boolean adicionarConsulta(Consulta consulta) {
        Set<Consulta> consultas = getConsultas();

        if (consultas.add(consulta)) {
            atualizarArquivo(consultas);
            return true;
        }

        return false;
    }

    public boolean atualizarConsultas(int id, Consulta consulta) {
        Set<Consulta> consultas = getConsultas();

        Consulta consultaParaRemover = null;

        for (Consulta consultaAtual : consultas) {
            if (consultaAtual.getId() == id) {
                consultaParaRemover = consultaAtual;
                break;
            }
        }

        if (consulta != null) {
            consultas.remove(consulta);
            consultas.add(consulta);
            atualizarArquivo(consultas);
            return true;
        }

        return false;
    }

    public boolean deletarConsulta(int id) {
        Set<Consulta> consultas = getConsultas();

        Consulta consultaParaRemover = null;

        for (Consulta consultaAtual : consultas) {
            if (consultaAtual.getId() == id) {
                consultaParaRemover = consultaAtual;
                break;
            }
        }

        if (consultaParaRemover != null) {
            consultas.remove(consultaParaRemover);
            atualizarArquivo(consultas);
            return true;
        }
        return false;
    }
}
