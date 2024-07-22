package br.com.fiap.soat7.grupo18.lanchonete.infrastructure.handler.dto;

public class CategoriaHandlerDto {
    private Long id;
    private String nome;

    
    public CategoriaHandlerDto() {
    }

    public CategoriaHandlerDto(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}