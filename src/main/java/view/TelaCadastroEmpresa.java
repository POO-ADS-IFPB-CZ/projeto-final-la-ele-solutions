package view;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class TelaCadastroEmpresa extends JFrame {
    private JTextField nomeEmpresaField;
    private JTextField cnpjField;

    public TelaCadastroEmpresa() {
        setTitle("Cadastro de Empresa");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        nomeEmpresaField = new JTextField(20);
        cnpjField = new JTextField(20);

        JLabel nomeEmpresaLabel = new JLabel("Nome da Empresa:");
        JLabel cnpjLabel = new JLabel("CNPJ:");

        JButton salvarButton = new JButton("Salvar");
        salvarButton.setBackground(new Color(60, 179, 113));
        salvarButton.setForeground(Color.WHITE);
        salvarButton.addActionListener(e -> salvarEmpresa());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        panel.add(nomeEmpresaLabel);
        panel.add(nomeEmpresaField);
        panel.add(cnpjLabel);
        panel.add(cnpjField);
        panel.add(new JLabel());
        panel.add(salvarButton);

        add(panel);
    }

    private void salvarEmpresa() {
        String nomeEmpresa = nomeEmpresaField.getText().trim();
        String cnpj = cnpjField.getText().trim();

        if (nomeEmpresa.isEmpty() || cnpj.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            File arquivo = new File("empresa_db.dat");
            if (arquivo.createNewFile()) {
                JOptionPane.showMessageDialog(this, "Arquivo criado com sucesso.");
            }

            JOptionPane.showMessageDialog(this, "Empresa cadastrada com sucesso!");

            new TelaCadastroCargo().setVisible(true);
            dispose();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Erro ao criar o arquivo.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            File arquivo = new File("empresa_db.dat");
            if (!arquivo.exists()) {
                new TelaCadastroEmpresa().setVisible(true);
            } else {
                new TelaCadastroCargo().setVisible(true);
            }
        });
    }
}
