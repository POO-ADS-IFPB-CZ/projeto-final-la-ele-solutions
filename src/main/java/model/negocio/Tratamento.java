package model.negocio;

import model.pessoa.Cliente;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Tratamento implements Serializable {
    private static final long serialVersionUID = 1L;;
    private String tipo;
    private LocalDate dataInicial;
    private LocalDate dataFinal;
    private String status;
    private final StringBuilder observacao = new StringBuilder();
    private final List<Consulta> consultas;
    private final Cliente cliente;

    public Tratamento(String tipo, LocalDate dataInicial, String status, List<Consulta> consultas, Cliente cliente) {
        this.tipo = tipo;
        this.dataInicial = dataInicial;
        this.status = status;
        this.consultas = new ArrayList<>(consultas);
        this.cliente = cliente;
    }

    public String getTipo() {
        return tipo;
    }


    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDate getDataInicial() {
        return dataInicial;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(LocalDate dataFinal) {
        this.dataFinal = dataFinal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getObservacao() {
        return observacao.toString();
    }

    public void adicionarObservacao(String novaObservacao) {
        if (novaObservacao != null && !novaObservacao.isBlank()) {
            observacao.append(novaObservacao).append("\n");
        }
    }

    public List<Consulta> getConsultas() {
        return new ArrayList<>(consultas);
    }

    public void setConsultas(List<Consulta> novasConsultas) {
        this.consultas.clear();
        this.consultas.addAll(novasConsultas);
    }

    public Cliente getCliente() {
        return cliente;
    }
}
