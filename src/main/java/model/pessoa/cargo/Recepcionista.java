package model.pessoa.cargo;

import model.negocio.Consulta;
import model.negocio.Tratamento;
import model.pessoa.Funcionario;
import model.pessoa.Cliente;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Recepcionista extends Funcionario {
    public Recepcionista(String cpf, String nome, char genero, String telefone, String email, LocalDate dataContratacao, int cargHoraria, BigDecimal salario, String status) {
        super(cpf, nome, genero, telefone, email, dataContratacao, "Recepcionista", cargHoraria, salario, status);
    }

    public Consulta criarConsulta(String tipo, BigDecimal valor, LocalDate data, Cliente cliente, Funcionario funcionario) {
        if (cliente == null || funcionario == null || valor == null || data == null || tipo == null || tipo.isEmpty()) {
            throw new IllegalArgumentException("Dados inválidos para criar consulta.");
        }
        return new Consulta(tipo, valor, data, cliente, funcionario);
    }

    public void modificarConsulta(Consulta consulta, String novoTipo, BigDecimal novoValor, LocalDate novaData) {
        if (consulta == null) return;
        if (novoTipo != null && !novoTipo.isEmpty()) consulta.setTipo(novoTipo);
        if (novoValor != null) consulta.setValor(novoValor);
        if (novaData != null) consulta.setData(novaData);
    }

    public void adicionarConsultaATratamento(Tratamento tratamento, Consulta consulta) {
        if (tratamento == null || consulta == null) return;
        if (!tratamento.getConsultas().contains(consulta)) {
            tratamento.getConsultas().add(consulta);
        }
    }
}