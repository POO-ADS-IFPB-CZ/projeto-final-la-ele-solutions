package view;

import model.negocio.Consulta;
import model.negocio.Tratamento;
import model.pessoa.cargo.Administrador;
import model.pessoa.Funcionario;
import model.pessoa.Cliente;
import model.negocio.Empresa;
import dao.EmpresaDAO;
import model.pessoa.cargo.Recepcionista;

import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class TelaAdministrador extends JFrame {

    private Administrador administrador;
    private Empresa empresa;

    public TelaAdministrador(Administrador administrador) {
        this.administrador = administrador;

        EmpresaDAO empresaDAO = new EmpresaDAO();
        this.empresa = empresaDAO.carregarEmpresa();

        setTitle("Funcionalidades Administrador");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel tipoConsultaLabel = new JLabel("Tipo da Consulta:");
        JTextField tipoConsultaField = new JTextField(20);
        JLabel valorConsultaLabel = new JLabel("Valor da Consulta:");
        JTextField valorConsultaField = new JTextField(20);
        JLabel dataConsultaLabel = new JLabel("Data da Consulta (yyyy-mm-dd):");
        JTextField dataConsultaField = new JTextField(20);
        JLabel clienteLabel = new JLabel("Cliente (CPF):");
        JTextField clienteField = new JTextField(20);
        JLabel funcionarioLabel = new JLabel("Funcionário (CPF):");
        JTextField funcionarioField = new JTextField(20);


        JButton adicionarConsultaButton = new JButton("Adicionar Consulta ao Tratamento");
        adicionarConsultaButton.addActionListener(e -> adicionarConsultaATratamento(clienteField.getText(), tipoConsultaField.getText()));

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(8, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        panel.add(tipoConsultaLabel);
        panel.add(tipoConsultaField);
        panel.add(valorConsultaLabel);
        panel.add(valorConsultaField);
        panel.add(dataConsultaLabel);
        panel.add(dataConsultaField);
        panel.add(clienteLabel);
        panel.add(clienteField);
        panel.add(funcionarioLabel);
        panel.add(funcionarioField);
        panel.add(adicionarConsultaButton);

        add(panel);
    }

    private void adicionarConsultaATratamento(String text, String text1) {
    }

    private Cliente encontrarClientePorCpf(String cpf) {
        for (Cliente cliente : empresa.getClientes()) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        return null;
    }

    private Funcionario encontrarFuncionarioPorCpf(String cpf) {
        for (Funcionario funcionario : empresa.getFuncionarios()) {
            if (funcionario.getCpf().equals(cpf)) {
                return funcionario;
            }
        }
        return null;
    }

    private Consulta selecionarConsultaParaModificar() {
        return new Consulta("Consulta exemplo", BigDecimal.TEN, LocalDate.now(), new Recepcionista("12345678900", "Recepcionista", 'M', "123456789", "email@empresa.com", LocalDate.now(), 40, BigDecimal.valueOf(2000), "Ativo"));
    }

    private Consulta encontrarConsultaPorTipo(String tipo) {
        return new Consulta(tipo, BigDecimal.TEN, LocalDate.now(), new Recepcionista("12345678900", "Recepcionista", 'M', "123456789", "email@empresa.com", LocalDate.now(), 40, BigDecimal.valueOf(2000), "Ativo"));
    }

    private Tratamento encontrarTratamentoPorCliente(Cliente cliente) {
        return new Tratamento("Tratamento Exemplo", LocalDate.now(), "Em andamento", List.of(new Consulta("Consulta Exemplo", BigDecimal.TEN, LocalDate.now(), new Recepcionista("12345678900", "Recepcionista", 'M', "123456789", "email@empresa.com", LocalDate.now(), 40, BigDecimal.valueOf(2000), "Ativo"))), cliente);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            EmpresaDAO empresaDAO = new EmpresaDAO();
            Empresa empresa = empresaDAO.carregarEmpresa();
            new TelaAdministrador(new Administrador("12345678900", "Administrador", 'M', "123456789", "admin@empresa.com", LocalDate.now(), 40, BigDecimal.valueOf(3000), "Ativo")).setVisible(true);
        });
    }
}
