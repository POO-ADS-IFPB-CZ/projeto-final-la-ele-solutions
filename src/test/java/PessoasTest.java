import org.junit.Assert;
import org.junit.Test;
import com.mayran.models.pessoas.Funcionario;

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
}
