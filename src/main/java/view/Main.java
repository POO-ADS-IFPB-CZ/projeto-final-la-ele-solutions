package view;

import dao.EmpresaDAO;
import model.negocio.Consulta;
import model.negocio.Empresa;
import model.negocio.Tratamento;
import model.pessoa.Cliente;
import model.pessoa.cargo.Administrador;
import model.pessoa.cargo.Dentista;
import model.pessoa.cargo.Recepcionista;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EmpresaDAO empresaDAO = new EmpresaDAO();

        Empresa empresa = new Empresa("12212233","Odonto");

        Administrador joao = new Administrador("12345678911","João",'M', "8311198888", "joao@email.com", LocalDate.of(2025, 3, 20), 33, BigDecimal.valueOf(2500.00),"Férias");
        Recepcionista recep = new Recepcionista("12312678911","Miguel",'M', "8399383888", "miguel@email.com", LocalDate.of(2025, 1, 11), 44, BigDecimal.valueOf(2500.00),"Ativo");
        empresa.adicionarFuncionario(joao);
        empresa.adicionarFuncionario(recep);


        Cliente cliente1 = new Cliente("111222333", "Pedro Santos", 'M', "1823444", "pedro@exemplo.com");
        Cliente cliente2 = new Cliente("444555666","Maria Oliveira" ,'F',"1823444", "maria@exemplo.com");
        empresa.adicionarCliente(cliente1);
        empresa.adicionarCliente(cliente2);

        System.out.println("Empresa salva com sucesso!");
        List<Consulta> listaConsultas = new ArrayList<>();

        Consulta consulta = recep.criarConsulta("Retorno", new BigDecimal(243.00), LocalDate.of(2025,03,11), cliente1, recep);
        listaConsultas.add(consulta);

        Tratamento tratamento = new Tratamento("Tratamento de canal", LocalDate.of(2025,03,11), "Ativo",listaConsultas,cliente1);
        empresa.adicionarTratamento(tratamento);
        empresaDAO.salvarEmpresa(empresa);

        Empresa empresaCarregada = empresaDAO.carregarEmpresa();
        if (empresaCarregada != null) {
            System.out.println("Empresa carregada:");
            System.out.println("Nome: " + empresaCarregada.getCNPJ());
            System.out.println("Funcionários: " + empresaCarregada.getFuncionarios().size());
            System.out.println("Clientes: " + empresaCarregada.getClientes().size());
            System.out.println("tratamentos: " + empresaCarregada.getTratamentos().get(0).getConsultas().toString());
        } else {
            System.out.println("Falha ao carregar a empresa.");
        }
    }
}
