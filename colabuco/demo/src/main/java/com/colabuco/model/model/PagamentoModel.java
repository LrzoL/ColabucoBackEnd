package com.colabuco.model.model;

import jakarta.persistence.*;

@Entity
@Table(name = "pagamento")
public class PagamentoModel {
        @Id
        @Column(name = "id_pagamento")
        private String id;
        @OneToOne(mappedBy = "pagamento")
        private PedidoModel pedido;

        private String formaPagamento;
        private int idTransacao;
    
        public PagamentoModel(String id, String formaPagamento, int idTransacao){
            this.id = id;
            this.formaPagamento = formaPagamento;
            this.idTransacao = idTransacao;
        }
    
        //ainda vamos estudar como integrar com a API do PagSeguro
    
        //getters
        public String getId() {
            return id;
        }
        public String getFormaPagamento() {
            return formaPagamento;
        }
        public int getIdTransacao() {
            return idTransacao;
        }
    }
