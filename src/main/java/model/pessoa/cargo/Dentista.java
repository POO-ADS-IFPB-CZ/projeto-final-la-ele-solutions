package model.pessoa.cargo;

import model.negocio.Empresa;
import model.negocio.Tratamento;
import model.pessoa.Funcionario;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

public class Dentista extends Funcionario implements Serializable {
    private static final long serialVersionUID = 1L;
    public Dentista(String cpf, String nome, char genero, String telefone, String email, LocalDate dataContratacao, int cargHoraria, BigDecimal salario, String status) {
        super(cpf, nome, genero, telefone, email, dataContratacao, "Dentista", cargHoraria, salario, status);
    }

    public void adicionarTratamento(Empresa empresa, Tratamento tratamento) {
        if (empresa == null || tratamento == null) return;
        if (!empresa.getTratamentos().contains(tratamento)) {
            empresa.adicionarTratamento(tratamento);
        }
    }

    public void modificarTratamento(Tratamento tratamento, String novoTipo, LocalDate novaDataFinal, String novoStatus) {
        if (tratamento == null) return;
        tratamento.setTipo(novoTipo);
        tratamento.setDataFinal(novaDataFinal);
        tratamento.setStatus(novoStatus);
    }

    public void removerTratamento(Empresa empresa, Tratamento tratamento) {
        if (empresa == null || tratamento == null) return;
        empresa.removerTratamento(tratamento);
    }
}
