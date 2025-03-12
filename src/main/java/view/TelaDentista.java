package view;

import model.negocio.Consulta;
import model.negocio.Tratamento;
import model.pessoa.cargo.Dentista;
import model.pessoa.Cliente;
import model.negocio.Empresa;
import dao.EmpresaDAO;

import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TelaDentista extends JFrame {

    private Dentista dentista;
    private Empresa empresa;

    public TelaDentista(Dentista dentista) {
        this.dentista = dentista;

        EmpresaDAO empresaDAO = new EmpresaDAO();
        this.empresa = empresaDAO.carregarEmpresa();

        setTitle("Funcionalidades Dentista");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel tipoTratamentoLabel = new JLabel("Tipo do Tratamento:");
        JTextField tipoTratamentoField = new JTextField(20);
        JLabel dataFinalLabel = new JLabel("Data Final do Tratamento (yyyy-mm-dd):");
        JTextField dataFinalField = new JTextField(20);
        JLabel statusLabel = new JLabel("Status do Tratamento:");
        JTextField statusField = new JTextField(20);
        JLabel clienteLabel = new JLabel("Cliente (CPF):");
        JTextField clienteField = new JTextField(20);

        JButton adicionarTratamentoButton = new JButton("Adicionar Tratamento");
        adicionarTratamentoButton.addActionListener(e -> adicionarTratamento(tipoTratamentoField.getText(), dataFinalField.getText(), statusField.getText(), clienteField.getText()));

        JButton modificarTratamentoButton = new JButton("Modificar Tratamento");
        modificarTratamentoButton.addActionListener(e -> modificarTratamento(tipoTratamentoField.getText(), dataFinalField.getText(), statusField.getText()));

        JButton removerTratamentoButton = new JButton("Remover Tratamento");
        removerTratamentoButton.addActionListener(e -> removerTratamento(clienteField.getText(), tipoTratamentoField.getText()));

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(8, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        panel.add(tipoTratamentoLabel);
        panel.add(tipoTratamentoField);
        panel.add(dataFinalLabel);
        panel.add(dataFinalField);
        panel.add(statusLabel);
        panel.add(statusField);
        panel.add(clienteLabel);
        panel.add(clienteField);
        panel.add(adicionarTratamentoButton);
        panel.add(modificarTratamentoButton);
        panel.add(removerTratamentoButton);

        add(panel);
    }

    private void adicionarTratamento(String tipo, String dataFinalString, String status, String clienteCpf) {
        try {
            LocalDate dataFinal = LocalDate.parse(dataFinalString);
            Cliente cliente = encontrarClientePorCpf(clienteCpf);

            if (cliente != null) {
                List<Consulta> consultas = new ArrayList<>();
                Tratamento tratamento = new Tratamento(tipo, LocalDate.now(), status, consultas, cliente);
                dentista.adicionarTratamento(empresa, tratamento);
                JOptionPane.showMessageDialog(this, "Tratamento adicionado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(this, "Cliente não encontrado.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao adicionar tratamento: " + e.getMessage());
        }
    }

    private void modificarTratamento(String tipo, String dataFinalString, String status) {
        try {
            Tratamento tratamento = selecionarTratamentoParaModificar();
            LocalDate novaDataFinal = LocalDate.parse(dataFinalString);

            dentista.modificarTratamento(tratamento, tipo, novaDataFinal, status);
            JOptionPane.showMessageDialog(this, "Tratamento modificado com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao modificar tratamento: " + e.getMessage());
        }
    }

    private void removerTratamento(String clienteCpf, String tipoTratamento) {
        try {
            Cliente cliente = encontrarClientePorCpf(clienteCpf);
            Tratamento tratamento = encontrarTratamentoPorCliente(cliente, tipoTratamento);

            if (tratamento != null) {
                dentista.removerTratamento(empresa, tratamento);
                JOptionPane.showMessageDialog(this, "Tratamento removido com sucesso!");
            } else {
                JOptionPane.showMessageDialog(this, "Tratamento não encontrado.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao remover tratamento: " + e.getMessage());
        }
    }

    private Cliente encontrarClientePorCpf(String cpf) {
        for (Cliente cliente : empresa.getClientes()) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        return null;
    }

    private Tratamento selecionarTratamentoParaModificar() {
        String clienteCpf = JOptionPane.showInputDialog(this, "Digite o CPF do cliente para modificar o tratamento:");
        Cliente cliente = encontrarClientePorCpf(clienteCpf);

        if (cliente != null) {
            for (Tratamento tratamento : empresa.getTratamentos()) {
                if (tratamento.getCliente().equals(cliente)) {
                    return tratamento;
                }
            }
            JOptionPane.showMessageDialog(this, "Nenhum tratamento encontrado para o cliente.");
        } else {
            JOptionPane.showMessageDialog(this, "Cliente não encontrado.");
        }

        return null;
    }

    private Tratamento encontrarTratamentoPorCliente(Cliente cliente, String tipo) {
        for (Tratamento tratamento : empresa.getTratamentos()) {
            if (tratamento.getCliente().equals(cliente) && tratamento.getTipo().equals(tipo)) {
                return tratamento;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            EmpresaDAO empresaDAO = new EmpresaDAO();
            Empresa empresa = empresaDAO.carregarEmpresa();
            new TelaDentista(new Dentista("12345678900", "Dr. João", 'M', "123456789", "dr.joao@email.com", LocalDate.now(), 40, BigDecimal.valueOf(3000), "Ativo")).setVisible(true);
        });
    }
}
