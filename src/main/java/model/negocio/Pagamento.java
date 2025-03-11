package model.negocio;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Pagamento {
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

    @Override
    public String toString() {
        return String.format("Pagamento do Tratamento ID: %d\n" +
                        "Valor Total: R$ %.2f\n" +
                        "Data de Pagamento: %s",
                tratamento.getId(), valorTotal, dataPagamento);
    }
}
