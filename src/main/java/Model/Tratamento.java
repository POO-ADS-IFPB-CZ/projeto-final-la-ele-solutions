package Model;

import pessoas.Cliente;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Tratamento {
    private static int contadorId = 1;
    private final int id;
    private String tipo;
    private LocalDate dataInicial;
    private LocalDate dataFinal;
    private String status;
    private final StringBuilder observacao = new StringBuilder();
    private final List<Consulta> consultas;
    private final Cliente cliente;

    public Tratamento(String tipo, LocalDate dataInicial, String status, List<Consulta> consultas, Cliente cliente) {
        this.id = contadorId++;
        this.tipo = tipo;
        this.dataInicial = dataInicial;
        this.status = status;
        this.consultas = new ArrayList<>(consultas);
        this.cliente = cliente;
    }

    public int getId() {
        return id;
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
