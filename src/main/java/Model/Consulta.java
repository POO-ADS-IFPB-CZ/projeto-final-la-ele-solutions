package Model;

import pessoas.Cliente;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Consulta {
    private int id;
    private String tipo;
    private BigDecimal valor;
    private LocalDate data;
    private Cliente cliente;

    public Consulta(int id, String tipo, BigDecimal valor, LocalDate data, Cliente cliente) {
        this.id = id;
        this.tipo = tipo;
        this.valor = valor;
        this.data = data;
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }
}
