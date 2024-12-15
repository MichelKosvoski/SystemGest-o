/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package br.com.projeto.model;

import java.util.Date;

public class Orcamento {

    private int idOrcamento;
    private String documentacao; // Novo campo
    private Date dataEmissao;
    private Date validade;
    private String formaPagamento;
    private String situacao;
    private int codigoCliente;
    private String vendedor;
    private String totalVenda;
    private String desconto;
    private String observacao;
    private String codigoDocumento;

    // Getter e Setter para o campo documentacao
    public String getDocumentacao() {
        return documentacao;
    }

    public void setDocumentacao(String documentacao) {
        this.documentacao = documentacao;
    }

    // Getter e Setter para o campo idOrcamento
    public int getIdOrcamento() {
        return idOrcamento;
    }

    public void setIdOrcamento(int idOrcamento) {
        this.idOrcamento = idOrcamento;
    }

    // Getter e Setter para dataEmissao
    public Date getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    // Getter e Setter para validade
    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }

    // Getter e Setter para formaPagamento
    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    // Getter e Setter para situacao
    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    // Getter e Setter para codigoCliente
    public int getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(int codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    // Getter e Setter para vendedor
    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    // Getter e Setter para totalVenda
    public String getTotalVenda() {
        return totalVenda;
    }

    public void setTotalVenda(String totalVenda) {
        this.totalVenda = totalVenda;
    }

    // Getter e Setter para desconto
    public String getDesconto() {
        return desconto;
    }

    public void setDesconto(String desconto) {
        this.desconto = desconto;
    }

    // Getter e Setter para observacao
    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    // Getter e Setter para codigoDocumento
    public String getCodigoDocumento() {
        return codigoDocumento;
    }

    public void setCodigoDocumento(String codigoDocumento) {
        this.codigoDocumento = codigoDocumento;
    }

    @Override
    public String toString() {
        return "Orcamento{" +
                "idOrcamento=" + idOrcamento +
                ", documentacao='" + documentacao + '\'' +
                ", dataEmissao=" + dataEmissao +
                ", validade=" + validade +
                ", formaPagamento='" + formaPagamento + '\'' +
                ", situacao='" + situacao + '\'' +
                ", codigoCliente=" + codigoCliente +
                ", vendedor='" + vendedor + '\'' +
                ", totalVenda='" + totalVenda + '\'' +
                ", desconto='" + desconto + '\'' +
                ", observacao='" + observacao + '\'' +
                ", codigoDocumento='" + codigoDocumento + '\'' +
                '}';
    }
}

