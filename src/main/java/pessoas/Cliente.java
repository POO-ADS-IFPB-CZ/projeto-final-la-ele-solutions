package pessoas;

public class Cliente extends Pessoa{
    public Cliente(String cpf, String nome, char genero, String telefone, String email) {
        super(cpf, nome, genero, telefone, email);
    }

    @Override
    public String toString() {
        return String.format("Cliente: %s - CPF: %s", super.getNome(), super.getCpf());
    }
}
