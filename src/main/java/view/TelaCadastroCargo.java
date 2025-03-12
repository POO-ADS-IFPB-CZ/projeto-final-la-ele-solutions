package view;

import javax.swing.*;
import java.awt.*;
import model.negocio.Empresa;
import dao.EmpresaDAO;

public class TelaCadastroCargo extends JFrame {

    private Empresa empresa;

    public TelaCadastroCargo() {
        EmpresaDAO empresaDAO = new EmpresaDAO();
        empresa = empresaDAO.carregarEmpresa();
        if (empresa == null) {
            empresa = new Empresa("12345678000195", "Minha Empresa");
        }

        setTitle("Escolha seu Cargo");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centraliza a tela

        JLabel cargoLabel = new JLabel("Escolha seu cargo:");
        cargoLabel.setFont(new Font("Arial", Font.BOLD, 16));

        JButton recepcionistaButton = new JButton("Recepcionista");
        recepcionistaButton.addActionListener(e -> abrirCadastroFuncionario("Recepcionista"));

        JButton administradorButton = new JButton("Administrador");
        administradorButton.addActionListener(e -> abrirCadastroFuncionario("Administrador"));

        JButton dentistaButton = new JButton("Dentista");
        dentistaButton.addActionListener(e -> abrirCadastroFuncionario("Dentista"));

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        panel.add(cargoLabel);
        panel.add(recepcionistaButton);
        panel.add(administradorButton);
        panel.add(dentistaButton);

        add(panel);
    }

    private void abrirCadastroFuncionario(String cargo) {
        new TelaCadastroFuncionario(cargo, empresa).setVisible(true);
        dispose();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaCadastroCargo().setVisible(true));
    }
}
