package Model;

import pessoas.Cliente;
import pessoas.Funcionario;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Consulta {
    private static int contadorId = 1;
    private int id;
    private String tipo;
    private BigDecimal valor;
    private LocalDate data;
    private Cliente cliente;
    private Funcionario funcionario;

    public Consulta(String tipo, BigDecimal valor, LocalDate data, Cliente cliente, Funcionario funcionario) {
        this.tipo = tipo;
        this.valor = valor;
        this.data = data;
        this.cliente = cliente;
        this.funcionario = funcionario;
    }

    public int getId() {
        return id;
    }
}
