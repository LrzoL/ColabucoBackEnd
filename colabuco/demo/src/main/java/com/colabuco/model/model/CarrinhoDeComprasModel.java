package com.colabuco.model.model;
import java.util.ArrayList;
import java.util.Random;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "tb_carrinho_de_compra_model")
public class CarrinhoDeComprasModel {
    Random random = new Random();
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private double valor;

   @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL, orphanRemoval = true)
    private ArrayList<ProdutoModel> produtos;
    
    @Column(nullable = false)
    private String cpfCliente;
    @Column(nullable = false)
    private PedidoModel pedido;
    @Column(nullable = false)
    private ClienteModel cliente;

    //construtor
    public CarrinhoDeComprasModel(String cpfCliente) {
        this.id = Integer.toString(random.nextLong());
        this.valor = 0.0;
        this.produtos = new ArrayList<ProdutoModel>();
        this.cpfCliente = cpfCliente;
    }

    //getters
    public Long getId() {
        return id;
    }
    public double getValor() {
        return valor;
    }
    public ArrayList<ProdutoModel> getProdutos() {
        return produtos;
    }
    public String getCpfCliente() {
        return cpfCliente;
    }

    //metódos
    public void adicionarProduto(ProdutoModel produto){
        this.produtos.add(produto);
        this.valor += produto.getPreco();
    }

    public void removerProduto(Long idProduto){
        for (int i = 0; i < this.produtos.size(); i++){
            if (this.produtos.get(i).getId() == idProduto){
                this.produtos.remove(this.produtos.get(i));
                this.valor -= this.produtos.get(i).getPreco();
            }
        }
    }

    public void limpar(){
        this.produtos.clear();
        this.valor = 0.0;
    }

    public void fazerPedido(String endereco){
        pedido = new PedidoModel(this.id, this.cpfCliente, endereco, this.valor);
        this.cliente.registrarPedido(pedido);
    }
}
