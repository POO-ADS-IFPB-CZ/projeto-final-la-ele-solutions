package model.negocio;

import model.pessoa.Funcionario;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

public class Consulta implements Serializable {
    private static final long serialVersionUID = 1L;
    private String tipo;
    private BigDecimal valor;
    private LocalDate data;
    private final Funcionario funcionario;

    public Consulta(String tipo, BigDecimal valor, LocalDate data, Funcionario funcionario) {
        if (tipo == null || valor == null || data == null || funcionario == null) {
            throw new IllegalArgumentException("Nenhum campo pode ser nulo");
        }

        this.tipo = tipo;
        this.valor = valor;
        this.data = data;
        this.funcionario = funcionario;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        if (tipo != null && !tipo.isEmpty()) {
            this.tipo = tipo;
        }
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        if (valor != null && valor.compareTo(BigDecimal.ZERO) > 0) {
            this.valor = valor;
        }
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        if (data != null && !data.isBefore(LocalDate.now())) {
            this.data = data;
        }
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }
}
