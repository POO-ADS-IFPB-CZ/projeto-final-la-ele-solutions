package com.mayran.models.pessoas;

public class Cliente extends Pessoa{
    private int id;
    private static int contadorId = 1;
    public Cliente(String cpf, String nome, char genero, String telefone, String email) {
        super(cpf, nome, genero, telefone, email);
        this.id = contadorId++;
    }

    public int getId() {
        return id;
    }
}
