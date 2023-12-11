package com.colabuco.model.model;
import java.util.ArrayList;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity 
@Table(name="tb_artista_model")
public class ArtistaModel extends ClienteModel{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String cnpj;
    @Column(nullable = false)
    private ArrayList<String> categoriaArte;
    @Column(nullable = false)
    private String politicaEntregaFrete;
    @Column(nullable = false)
    private String descricao;
    
    @Column(nullable = false)
    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL, orphanRemoval = true)
    private ArrayList<ProdutoModel> produtos;

    public ArtistaModel(Long id, String nome, String email, String cpf, String telefone, String senha, String endereco, String cnpj, ArrayList<String> categoriaArte, String politicaEntregaFrete, String descricao){
        super(id, nome, email, cpf, telefone, senha, endereco);
        this.cnpj = cnpj;
        categoriaArte = new ArrayList<String>();
        this.politicaEntregaFrete = politicaEntregaFrete;
        this.descricao = descricao;
        this.produtos = new ArrayList<ProdutoModel>();
    }

    //Sobrecarga de construtor
    public ArtistaModel(Long id, String nome, String email, String cpf, String telefone, String senha, String endereco, ArrayList<String> categoriaArte, String politicaEntregaFrete, String descricao){
        super(id, nome, email, cpf, telefone, senha, endereco);
        this.cnpj = null;
        categoriaArte = new ArrayList<String>();
        this.politicaEntregaFrete = politicaEntregaFrete;
        this.descricao = descricao;
        this.produtos = new ArrayList<ProdutoModel>();
    }

    //getters
    public String getCnpjModel(){
        return this.cnpj;
    }
    public ArrayList<String> getCategoriaArte(){
        return this.categoriaArte;
    }
    public String getPoliticaEntregaFrete(){
        return this.politicaEntregaFrete;
    }
    public String getDescricao(){
        return this.descricao;
    }
    public ArrayList<ProdutoModel> getProdutos(){
        return produtos;
    }

    //setters
    public void setCnpj(String novoCnpj){
        this.cnpj = novoCnpj;
    }
    public void setCategoriaArte (ArrayList<String> novaCategoriaArte){
        this.categoriaArte = novaCategoriaArte;
    }
    public void setPoliticaEntregaFrete(String novaPoliticaEntregaFrete){
        this.politicaEntregaFrete = novaPoliticaEntregaFrete;
    }
    public void setDescricao(String novaDescricao){
        this.descricao = novaDescricao;
    }

    //métodos
    public void cadastrarProduto(Long id, String nome, ArrayList<String> categoria, String descricao, double preco, ArtistaModel artista){
        ProdutoModel p1 = new ProdutoModel(id, nome, categoria, descricao, preco, artista);
        produtos.add(p1);
    }

}