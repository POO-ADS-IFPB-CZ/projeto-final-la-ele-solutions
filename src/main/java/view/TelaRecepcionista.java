package view;

import model.negocio.Consulta;
import model.negocio.Tratamento;
import model.pessoa.cargo.Recepcionista;
import model.pessoa.Funcionario;
import model.pessoa.Cliente;
import model.negocio.Empresa;
import dao.EmpresaDAO;

import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class TelaRecepcionista extends JFrame {

    private Recepcionista recepcionista;
    private Empresa empresa;

    public TelaRecepcionista(Recepcionista recepcionista) {
        this.recepcionista = recepcionista;

        EmpresaDAO empresaDAO = new EmpresaDAO();
        this.empresa = empresaDAO.carregarEmpresa();


        setTitle("Funcionalidades Recepcionista");
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

        JButton criarConsultaButton = new JButton("Criar Consulta");
        criarConsultaButton.addActionListener(e -> criarConsulta(tipoConsultaField.getText(), valorConsultaField.getText(), dataConsultaField.getText(), clienteField.getText(), funcionarioField.getText()));

        JButton modificarConsultaButton = new JButton("Modificar Consulta");
        modificarConsultaButton.addActionListener(e -> modificarConsulta(tipoConsultaField.getText(), valorConsultaField.getText(), dataConsultaField.getText()));

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
        panel.add(criarConsultaButton);
        panel.add(modificarConsultaButton);
        panel.add(adicionarConsultaButton);

        add(panel);
    }

    private void criarConsulta(String tipo, String valorString, String dataString, String clienteCpf, String funcionarioCpf) {
        try {
            BigDecimal valor = new BigDecimal(valorString);
            LocalDate data = LocalDate.parse(dataString);
            Cliente cliente = encontrarClientePorCpf(clienteCpf);
            Funcionario funcionario = encontrarFuncionarioPorCpf(funcionarioCpf);

            if (cliente != null && funcionario != null) {
                Consulta consulta = recepcionista.criarConsulta(tipo, valor, data, cliente, funcionario);
                JOptionPane.showMessageDialog(this, "Consulta criada com sucesso!");
            } else {
                JOptionPane.showMessageDialog(this, "Cliente ou Funcionário não encontrados.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao criar consulta: " + e.getMessage());
        }
    }

    private void modificarConsulta(String tipo, String valorString, String dataString) {
        try {
            Consulta consulta = selecionarConsultaParaModificar();
            BigDecimal novoValor = new BigDecimal(valorString);
            LocalDate novaData = LocalDate.parse(dataString);

            recepcionista.modificarConsulta(consulta, tipo, novoValor, novaData);
            JOptionPane.showMessageDialog(this, "Consulta modificada com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao modificar consulta: " + e.getMessage());
        }
    }

    private void adicionarConsultaATratamento(String clienteCpf, String tipoConsulta) {
        try {
            Cliente cliente = encontrarClientePorCpf(clienteCpf);
            Consulta consulta = encontrarConsultaPorTipo(tipoConsulta);
            Tratamento tratamento = encontrarTratamentoPorCliente(cliente);

            recepcionista.adicionarConsultaATratamento(tratamento, consulta);
            JOptionPane.showMessageDialog(this, "Consulta adicionada ao tratamento com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao adicionar consulta ao tratamento: " + e.getMessage());
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
            new TelaRecepcionista(new Recepcionista("12345678900", "João", 'M', "123456789", "joao@email.com", LocalDate.now(), 40, BigDecimal.valueOf(2000), "Ativo")).setVisible(true);
        });
    }
}
