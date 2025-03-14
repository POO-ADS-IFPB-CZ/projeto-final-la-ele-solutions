package model.pessoa;

import java.io.Serializable;

public abstract class Pessoa implements Serializable{
    private static final long serialVersionUID = 1L;
    private final String cpf;
    private String nome;
    private char genero;
    private String telefone;
    private String email;

    public Pessoa(String cpf, String nome, char genero, String telefone, String email) {
        if (cpf == null || cpf.isEmpty()) throw new IllegalArgumentException("CPF não pode ser nulo ou vazio");
        if (nome == null || nome.isEmpty()) throw new IllegalArgumentException("Nome não pode ser nulo ou vazio");
        if (!Character.toString(genero).matches("[MF]")) throw new IllegalArgumentException("Gênero deve ser 'M' ou 'F'");
        if (!email.contains("@")) throw new IllegalArgumentException("Email inválido");

        this.cpf = cpf;
        this.nome = nome;
        this.genero = genero;
        this.telefone = telefone;
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome != null && !nome.isEmpty()) {
            this.nome = nome;
        }
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        if (Character.toString(genero).matches("[MF]")) {
            this.genero = genero;
        }
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        if (telefone != null && !telefone.isEmpty()) {
            this.telefone = telefone;
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email != null && !email.isEmpty() && email.contains("@")) {
            this.email = email;
        }
    }
}