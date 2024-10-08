package br.com.fiap.soat7.grupo18.lanchonete.external.infra.persistence.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "produto")
public class ProdutoEntity {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "preco", nullable = false)
    private BigDecimal preco;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_categoria", nullable = false)
    private CategoriaEntity categoria;

    @Builder.Default
    @Column(nullable = false)
    private boolean ativo = true;

    @Builder.Default
    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL)
    private List<PedidoProdutoEntity> produtos = new ArrayList<>();

}
