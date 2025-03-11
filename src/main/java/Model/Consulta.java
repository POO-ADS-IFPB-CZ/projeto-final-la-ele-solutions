package Model;

import pessoas.Cliente;
import pessoas.Funcionario;
import java.math.BigDecimal;
import java.time.LocalDate;

public class Consulta {
    private static int contadorId = 1;
    private final int id;
    private String tipo;
    private BigDecimal valor;
    private LocalDate data;
    private final Cliente cliente;
    private final Funcionario funcionario;

    public Consulta(String tipo, BigDecimal valor, LocalDate data, Cliente cliente, Funcionario funcionario) {
        if (tipo == null || valor == null || data == null || cliente == null || funcionario == null) {
            throw new IllegalArgumentException("Nenhum campo pode ser nulo");
        }

        this.id = contadorId++;
        this.tipo = tipo;
        this.valor = valor;
        this.data = data;
        this.cliente = cliente;
        this.funcionario = funcionario;
    }

    public int getId() {
        return id;
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

    public Cliente getCliente() {
        return cliente;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }
}
