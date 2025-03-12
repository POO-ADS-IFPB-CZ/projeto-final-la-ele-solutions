package model.negocio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

public class Pagamento implements Serializable {
    private static final long serialVersionUID = 1L;
    private Tratamento tratamento;
    private BigDecimal valorTotal;
    private LocalDate dataPagamento;

    public Pagamento(Tratamento tratamento, LocalDate dataPagamento) {
        if (tratamento == null || dataPagamento == null) {
            throw new IllegalArgumentException("Tratamento e Data de Pagamento não podem ser nulos");
        }

        this.tratamento = tratamento;
        this.dataPagamento = dataPagamento;
        this.valorTotal = calcularValorTotal(tratamento);
    }



    private BigDecimal calcularValorTotal(Tratamento tratamento) {
        BigDecimal total = BigDecimal.ZERO;
        for (Consulta consulta : tratamento.getConsultas()) {
            total = total.add(consulta.getValor());
        }
        return total;
    }

    public Tratamento getTratamento() {
        return tratamento;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }
}
