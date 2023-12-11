package com.colabuco.model.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_pedido_model")
public class PedidoModel {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private String id;
        @Column(nullable = false)
        private String cpfCliente;
        @Column(nullable = false)
        private String cnpjArtista;
        @Column(nullable = false)
        private String endereco;
        @Column(nullable = false)
        private String opcoesEntrega;
        @Column(nullable = false)
        private double valor;

        @ManyToOne
        @JoinColumn(name = "id_cliente_model", referencedColumnName = "id")
        private ClienteModel c1;
    
        public PedidoModel(String id, String cpfCliente, String endereco, double valor){
            this.id = id;
            this.cpfCliente = cpfCliente;
            this.endereco = endereco;
            this.valor = valor;
        }
    
        //getters
        public String getId() {
            return id;
        }
        public String getCpfCliente() {
            return cpfCliente;
        }
        public String getCnpjArtista() {
            return cnpjArtista;
        }
        public String getEndereco() {
            return endereco;
        }
        public String getOpcoesEntrega() {
            return opcoesEntrega;
        }
        public double getValor() {
            return valor;
        }
    
        //setters
        public void setCpfCliente(String cpfCliente) {
            this.cpfCliente = cpfCliente;
        }
        public void setCnpjArtista(String cnpjArtista) {
            this.cnpjArtista = cnpjArtista;
        }
        public void setEndereco(String endereco) {
            this.endereco = endereco;
        }
        public void setOpcoesEntrega(String opcoesEntrega) {
            this.opcoesEntrega = opcoesEntrega;
        }
        public void setValor(double valor) {
            this.valor = valor;
        }
    }
