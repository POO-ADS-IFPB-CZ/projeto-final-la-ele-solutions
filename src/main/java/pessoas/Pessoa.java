package pessoas;

public abstract class Pessoa {
    private static int contadorId = 1;
    private int id;
    private String cpf;
    private String nome;
    private char genero;
    private String telefone;
    private String email;

    public Pessoa(String cpf, String nome, char genero, String telefone, String email) {
        this.id = contadorId++;
        this.cpf = cpf;
        this.nome = nome;
        this.genero = genero;
        this.telefone = telefone;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
