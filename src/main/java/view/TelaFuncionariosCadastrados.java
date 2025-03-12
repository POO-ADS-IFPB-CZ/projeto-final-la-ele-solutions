package view;

import model.pessoa.Funcionario;
import model.pessoa.cargo.Administrador;
import model.pessoa.cargo.Dentista;
import model.pessoa.cargo.Recepcionista;
import dao.EmpresaDAO;
import model.negocio.Empresa;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TelaFuncionariosCadastrados extends JFrame {

    private Empresa empresa;

    public TelaFuncionariosCadastrados() {
        EmpresaDAO empresaDAO = new EmpresaDAO();
        this.empresa = empresaDAO.carregarEmpresa();


        setTitle("Funcionários Cadastrados");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        DefaultListModel<String> listModel = new DefaultListModel<>();
        List<Funcionario> funcionarios = empresa.getFuncionarios();

        for (Funcionario funcionario : funcionarios) {
            listModel.addElement(funcionario.getNome() + " - CPF: " + funcionario.getCpf());
        }

        JList<String> listaFuncionarios = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(listaFuncionarios);
        JButton acessarButton = new JButton("Acessar Recepcionista");

        acessarButton.addActionListener(e -> {
            Funcionario funcionarioSelecionado = getFuncionarioSelecionado(listaFuncionarios);
            if (funcionarioSelecionado != null) {
                if (funcionarioSelecionado instanceof Recepcionista) {
                    TelaRecepcionista telaRecepcionista = new TelaRecepcionista((Recepcionista) funcionarioSelecionado);
                    telaRecepcionista.setVisible(true);
                } else if (funcionarioSelecionado instanceof Dentista) {
                    // Tela para Dentista
                    TelaDentista telaDentista = new TelaDentista((Dentista) funcionarioSelecionado);
                    telaDentista.setVisible(true);
                } else if (funcionarioSelecionado instanceof Administrador) {
                    // Tela para Administrador
                    TelaAdministrador telaAdministrador = new TelaAdministrador((Administrador) funcionarioSelecionado);
                    telaAdministrador.setVisible(true);
                }
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Nenhum funcionário selecionado.");
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(acessarButton, BorderLayout.SOUTH);

        add(panel);
    }

    private Funcionario getFuncionarioSelecionado(JList<String> listaFuncionarios) {
        int indiceSelecionado = listaFuncionarios.getSelectedIndex();
        if (indiceSelecionado != -1) {
            String funcionarioInfo = listaFuncionarios.getSelectedValue();
            String cpf = funcionarioInfo.split(" - CPF: ")[1];

            for (Funcionario funcionario : empresa.getFuncionarios()) {
                if (funcionario.getCpf().equals(cpf)) {
                    return funcionario;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaFuncionariosCadastrados().setVisible(true));
    }
}
