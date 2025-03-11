import org.junit.Assert;
import org.junit.Test;
import pessoas.Cliente;
import pessoas.Funcionario;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PessoasTest {
    @Test
    public void deveConseguirInstanciarFuncionario(){
        String resultadoEsperado = "Funcionário:\n" +
                "  Nome: João\n" +
                "  CPF: 12345678911\n" +
                "  Gênero: M\n" +
                "  Telefone: 8399998888\n" +
                "  Email: joao@email.com\n" +
                "  Data de Contratação: 2025-03-11\n" +
                "  Cargo: Dentista\n" +
                "  Carga Horária: 44 horas\n" +
                "  Salário: R$ 2500,00\n" +
                "  Status: Férias";

        Funcionario funcionarioJoao = new Funcionario("12345678911","João",'M',
                "8399998888", "joao@email.com", LocalDate.of(2025, 3, 11),
                "Dentista", 44, BigDecimal.valueOf(2500.00),"Férias");

        Assert.assertEquals(resultadoEsperado, funcionarioJoao.toString());
    }
    @Test
    public void deveConseguirInstanciarCliente(){
        String resultadoEsperado = "Cliente: Pedro - CPF: 18293748532";

        Cliente pedro = new Cliente("18293748532","Pedro",'M',"8299991234", "pedro@email.com");

        Assert.assertEquals(resultadoEsperado, pedro.toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void DeveRetornarExceptionAoTentarInstanciarFuncionarioSemNome()
        throws IllegalArgumentException {
        Funcionario joaoSemNome = new Funcionario("12345678912", "", 'M', "8399998888", "joao@email.com", LocalDate.of(2025, 3, 11),
                "Dentista", 44, BigDecimal.valueOf(2500.00),"Férias");
    }

    @Test(expected = IllegalArgumentException.class)
    public void DeveRetornarExceptionAoTentarInstanciarClienteComEmailInvalido()
            throws IllegalArgumentException {
        Cliente Bruna = new Cliente("18234587125", "Bruna da Silva", 'F',"8299991234", "bruna.com");
    }
}