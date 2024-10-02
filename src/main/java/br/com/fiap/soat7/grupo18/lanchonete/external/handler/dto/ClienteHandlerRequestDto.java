package br.com.fiap.soat7.grupo18.lanchonete.external.handler.dto;

public class ClienteHandlerRequestDto {

    private String cpf;

    private String nome;

    private String email;

    private String senha;

    

    public ClienteHandlerRequestDto() {
    }

    /**
     * 
     * @param cpf
     * @param nome
     * @param email
     * @param senha
     */
    public ClienteHandlerRequestDto(String cpf, String nome, String email, String senha) {
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

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    

    
}
