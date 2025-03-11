import Model.Empresa;
import org.junit.Assert;
import org.junit.Test;
import pessoas.Funcionario;
import pessoas.cargos.Administrador;
import pessoas.cargos.Dentista;
import pessoas.cargos.Recepcionista;

import java.math.BigDecimal;
import java.time.LocalDate;

public class EmpresaTest {
    @Test
    public void deveConseguirCriarNovaEmpresaEContratar3Funcionarios(){
        Funcionario joao = new Administrador("12345678911","João",'M', "8311198888", "joao@email.com", LocalDate.of(2025, 3, 20), 33, BigDecimal.valueOf(2500.00),"Férias");
        Funcionario miguel = new Dentista("12312678911","Miguel",'M', "8399383888", "miguel@email.com", LocalDate.of(2025, 1, 11), 44, BigDecimal.valueOf(2500.00),"Ativo");
        Funcionario marcela = new Recepcionista("12345678211","Marcela",'F', null, "marcela@email.com", LocalDate.of(2025, 3, 3), 44, BigDecimal.valueOf(1900.00),"Ativo");

        Empresa tiraDentes = new Empresa("13782837481234", "Odontologia");
        tiraDentes.adicionarFuncionario(joao);
        tiraDentes.adicionarFuncionario(miguel);
        tiraDentes.adicionarFuncionario(marcela);
        int ResultadoEsperado = 3;
        int Resultado = tiraDentes.getFuncionarios().toArray().length;

        Assert.assertEquals(ResultadoEsperado, Resultado);
    }
}
