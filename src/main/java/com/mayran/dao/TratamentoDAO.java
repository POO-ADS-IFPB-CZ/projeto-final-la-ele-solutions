package com.mayran.dao;

import com.mayran.models.Tratamento;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class TratamentoDAO {
    private File arquivo;

    public TratamentoDAO() {
        arquivo = new File("Tratamentos.txt");
        if (!arquivo.exists()){
            try {
                arquivo.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Set<Tratamento> getTratamentos() {
        Set<Tratamento> tratamentos = new HashSet<>();
        if (arquivo.length() == 0) {
            return tratamentos;
        }

        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(arquivo))) {
            tratamentos = (Set<Tratamento>) in.readObject();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return tratamentos;
    }

    private void atualizarArquivo(Set<Tratamento> tratamentos) {
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(arquivo))){
            out.writeObject(tratamentos);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Tratamento buscarTratamento(int id) {
        Set<Tratamento> tratamentos = getTratamentos();

        for(Tratamento tratamentoAtual : tratamentos) {
            if (tratamentoAtual.getId() == id) {
                return tratamentoAtual;
            }
        }

        return null;
    }

    public boolean adicionarTratamento(Tratamento tratamento) {
        Set<Tratamento> tratamentos = getTratamentos();

        if (tratamentos.add(tratamento)) {
            atualizarArquivo(tratamentos);
            return true;
        }

        return false;
    }

    public boolean atualizarTratamento(int id, Tratamento tratamento) {
        Set<Tratamento> tratamentos = getTratamentos();

        Tratamento tratamentoParaRemover = null;

        for (Tratamento tratamentoAtual : tratamentos) {
            if (tratamentoAtual.getId() == id) {
                tratamentoParaRemover = tratamentoAtual;
                break;
            }
        }

        if (tratamentoParaRemover != null) {
            tratamentos.remove(tratamentoParaRemover);
            tratamentos.add(tratamento);
            atualizarArquivo(tratamentos);
            return true;
        }

        return false;
    }

    public boolean deletarTratamento(int id) {
        Set<Tratamento> tratamentos = getTratamentos();

        Tratamento tratamentoParaRemover = null;

        for (Tratamento tratamentoAtual : tratamentos) {
            if (tratamentoAtual.getId() == id) {
                tratamentoParaRemover = tratamentoAtual;
                break;
            }
        }

        if (tratamentoParaRemover != null) {
            tratamentos.remove(tratamentoParaRemover);
            atualizarArquivo(tratamentos);
            return true;
        }
        return false;
    }
}
