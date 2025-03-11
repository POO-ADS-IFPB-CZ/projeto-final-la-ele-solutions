package Model;

import pessoas.Cliente;

import java.time.LocalDate;
import java.util.List;

public class Tratamento {
    private static int contadorId = 1;
    private int id;
    private String tipo;
    private LocalDate dataInicial;
    private LocalDate dataFinal;
    private String status;
    private StringBuilder observacao = new StringBuilder();
    private List<Consulta> consultas;
    private Cliente cliente;

    public Tratamento(String tipo, LocalDate dataInicial, String status, List<Consulta> consultas, Cliente cliente) {
        this.tipo = tipo;
        this.dataInicial = dataInicial;
        this.status = status;
        this.consultas = consultas;
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

    public StringBuilder getObservacao() {
        return observacao;
    }

    public void setObservacao(StringBuilder observacao) {
        this.observacao = observacao;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    //TODO: aplicar regras aqui futuramente
    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public int getId() {
        return id;
    }
}

