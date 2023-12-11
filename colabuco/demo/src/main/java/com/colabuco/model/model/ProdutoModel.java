package com.colabuco.model.model;
import java.util.ArrayList;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_produto_model")
public class ProdutoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private ArrayList<String> categoria;
    @Column(nullable = false)
    private String descricao;
    @Column(nullable = false)
    private double preco;
    
    @ManyToOne
    @JoinColumn(name = "id_artista_model", referencedColumnName = "id")
    private ArtistaModel artista;

    @ManyToOne
    @JoinColumn(name = "id_carrinho_de_compras_model", referencedColumnName = "id")    
    private CarrinhoDeComprasModel carrinho1;

    public ProdutoModel(Long id, String nome, ArrayList<String> categoria, String descricao, double preco, ArtistaModel artista){
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.descricao = descricao;
        this.preco = preco;
        this.artista = artista;
    }

    public Long getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<String> getCategoria() {
        return categoria;
    }

    public void setCategoria(ArrayList<String> categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}

