package com.colabuco.model.model;
import java.util.ArrayList;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_cliente_model")
public class ClienteModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    @Column(nullable = false)
    protected String cpf, nome, email, telefone, endereco, senha;
    protected CarrinhoDeComprasModel carrinho;
    
    @OneToMany(mappedBy = "cartao", cascade = CascadeType.ALL, orphanRemoval = true)
    protected ArrayList<CartaoModel> cartoes; 
    
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    protected ArrayList<PedidoModel> pedidos;

    //construtor
    public ClienteModel(Long id, String nome, String email, String cpf, String telefone, String senha, String endereco) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
        this.senha = senha; //precisa?

        this.carrinho = new CarrinhoDeComprasModel(this.cpf);
        this.cartoes = new ArrayList<CartaoModel>();
    }

    //getters
    public String getCpf() {
        return cpf;
    }
    public String getNome() {
        return nome;
    }
    public String getEmail() {
        return email;
    }
    public String getTelefone() {
        return telefone;
    }
    public String getEndereco() {
        return endereco;
    }
    public String getSenha() {
        return senha;
    }
    public CarrinhoDeComprasModel getCarrinho() {
        return carrinho;
    }
    public ArrayList<CartaoModel> getCartoes() {
        return cartoes;
    }
    public ArrayList<PedidoModel> getPedidos(){
        return pedidos;
    }

    //setters
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

    //métodos
    protected void adicionarAoCarrinho(ProdutoModel produto){
        this.carrinho.adicionarProduto(produto);
    }
    protected void removerDoCarrinho(String idProduto){
        this.carrinho.removerProduto(idProduto);
    }
    protected void limparCarrinho(){
        this.carrinho.limpar();
    }

    protected void adicionarCartao(String apelido, String numCartao, String validade, String nomeTitular, String instituicaoCartao, String bandeira, int cvv){
        CartaoModel cartao = new CartaoModel(apelido, numCartao, validade, nomeTitular, instituicaoCartao, bandeira, cvv);
        this.cartoes.add(cartao);
    }
    protected void removerCartao(String numCartao){
        for (int i = 0; i < this.cartoes.size(); i++){
            if (this.cartoes.get(i).getNumCartao() == numCartao){
                this.cartoes.remove(this.cartoes.get(i));
            }
        }
    }

    protected void finalizarCompra(){
        this.carrinho.fazerPedido(endereco);
    }

    public void registrarPedido(PedidoModel pedido){
        this.pedidos.add(pedido);
    }
}