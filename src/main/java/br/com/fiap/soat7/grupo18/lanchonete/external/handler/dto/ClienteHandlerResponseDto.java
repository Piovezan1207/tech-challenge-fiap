package br.com.fiap.soat7.grupo18.lanchonete.external.handler.dto;

public class ClienteHandlerResponseDto {

    private final String cpf;

    private final String nome;

    private final String email;

    private final String senha;

    /**
     * 
     * @param cpf
     * @param nome
     * @param email
     * @param senha
     */
    public ClienteHandlerResponseDto(String cpf, String nome, String email, String senha) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha(){
        return "******";
    }

}
