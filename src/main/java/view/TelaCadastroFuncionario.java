package view;

import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import model.negocio.Empresa;
import model.pessoa.Funcionario;
import model.pessoa.cargo.Administrador;
import model.pessoa.cargo.Dentista;
import model.pessoa.cargo.Recepcionista;

public class TelaCadastroFuncionario extends JFrame {

    private String cargo;
    private Empresa empresa;

    public TelaCadastroFuncionario(String cargo, Empresa empresa) {
        this.cargo = cargo;
        this.empresa = empresa;

        setTitle("Cadastro de Funcionário");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centraliza a tela

        // Criando os campos de entrada para as informações do funcionário
        JLabel cpfLabel = new JLabel("CPF:");
        JTextField cpfField = new JTextField(20);
        JLabel nomeLabel = new JLabel("Nome:");
        JTextField nomeField = new JTextField(20);
        JLabel generoLabel = new JLabel("Gênero:");
        JTextField generoField = new JTextField(20);
        JLabel telefoneLabel = new JLabel("Telefone:");
        JTextField telefoneField = new JTextField(20);
        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField(20);
        JLabel dataContratacaoLabel = new JLabel("Data de Contratação:");
        JTextField dataContratacaoField = new JTextField(20);
        JLabel cargaHorariaLabel = new JLabel("Carga Horária:");
        JTextField cargaHorariaField = new JTextField(20);
        JLabel salarioLabel = new JLabel("Salário:");
        JTextField salarioField = new JTextField(20);
        JLabel statusLabel = new JLabel("Status:");
        JTextField statusField = new JTextField(20);

        // Botão para salvar o funcionário
        JButton salvarButton = new JButton("Salvar Funcionário");
        salvarButton.addActionListener(e -> salvarFuncionario(cpfField.getText(), nomeField.getText(), generoField.getText().charAt(0), telefoneField.getText(), emailField.getText(), dataContratacaoField.getText(), Integer.parseInt(cargaHorariaField.getText()), Double.parseDouble(salarioField.getText()), statusField.getText()));

        // Botão para ver os funcionários já cadastrados
        JButton verFuncionariosButton = new JButton("Ver Funcionários já Cadastrados");
        verFuncionariosButton.addActionListener(e -> abrirTelaFuncionariosCadastrados());

        // Organizando a tela com um layout
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(12, 2, 10, 10)); // Organizando os campos
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Espaçamento ao redor

        panel.add(cpfLabel);
        panel.add(cpfField);
        panel.add(nomeLabel);
        panel.add(nomeField);
        panel.add(generoLabel);
        panel.add(generoField);
        panel.add(telefoneLabel);
        panel.add(telefoneField);
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(dataContratacaoLabel);
        panel.add(dataContratacaoField);
        panel.add(cargaHorariaLabel);
        panel.add(cargaHorariaField);
        panel.add(salarioLabel);
        panel.add(salarioField);
        panel.add(statusLabel);
        panel.add(statusField);
        panel.add(salvarButton);
        panel.add(verFuncionariosButton);

        add(panel);
    }

    private void salvarFuncionario(String cpf, String nome, char genero, String telefone, String email, String dataContratacao, int cargaHoraria, double salario, String status) {
        Funcionario funcionario = null;

        switch (cargo) {
            case "Recepcionista":
                funcionario = new Recepcionista(cpf, nome, genero, telefone, email, LocalDate.parse(dataContratacao), cargaHoraria, BigDecimal.valueOf(salario), status);
                break;
            case "Administrador":
                funcionario = new Administrador(cpf, nome, genero, telefone, email, LocalDate.parse(dataContratacao), cargaHoraria, BigDecimal.valueOf(salario), status);
                break;
            case "Dentista":
                funcionario = new Dentista(cpf, nome, genero, telefone, email, LocalDate.parse(dataContratacao), cargaHoraria, BigDecimal.valueOf(salario), status);
                break;
        }

        if (funcionario != null) {
            empresa.adicionarFuncionario(funcionario);
            JOptionPane.showMessageDialog(this, "Funcionário cadastrado com sucesso!");
        }
    }

    private void abrirTelaFuncionariosCadastrados() {
        // Abrir a tela de ver funcionários cadastrados
        new TelaFuncionariosCadastrados().setVisible(true);
        dispose(); // Fecha a tela de cadastro
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaCadastroFuncionario("Administrador", new Empresa("12345678000195", "Minha Empresa")).setVisible(true));
    }
}
