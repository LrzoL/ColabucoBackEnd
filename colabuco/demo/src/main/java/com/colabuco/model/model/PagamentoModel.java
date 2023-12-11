package com.colabuco.model.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.*;


@Entity
@Table(name = "tb_pagamento_model")
public class PagamentoModel {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id_pagamento")
        private String id;
        @Column(nullable = false)
        @OneToOne(mappedBy = "pagamento")
        private PedidoModel pedido;
        private String formaPagamento;
        @Column(nullable = false)
        private int idTransacao;
    
        @ManyToOne
        @JoinColumn(name = "id_cartao_model", referencedColumnName = "numCartao")
        private CartaoModel ct;

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
