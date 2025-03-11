package com.mayran.models;

import com.mayran.models.pessoas.Cliente;
import com.mayran.models.pessoas.Funcionario;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Consulta {
    private int id;
    private String tipo;
    private BigDecimal valor;
    private LocalDate data;
    private Cliente cliente;
    private Funcionario funcionario;
    private static int contadorId = 1;

    public Consulta(String tipo, BigDecimal valor, LocalDate data, Cliente cliente, Funcionario funcionario) {
        this.tipo = tipo;
        this.valor = valor;
        this.data = data;
        this.cliente = cliente;
        this.funcionario = funcionario;
        this.id = contadorId++;
    }

    public int getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public LocalDate getData() {
        return data;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public static int getContadorId() {
        return contadorId;
    }
}
