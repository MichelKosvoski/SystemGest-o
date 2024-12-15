/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto.dao;

import br.com.projeto.jbdc.ConnectionFactory;
import br.com.projeto.model.Orcamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OrcamentoDAO {

    private Connection con;

    public OrcamentoDAO() {
        this.con = new ConnectionFactory().getConnection();
    }

    // Método para adicionar um novo orçamento
    public void adicionarOrcamento(Orcamento obj) {
        String sql = "INSERT INTO tb_orcamento (data_emissao, validade, forma_pagamento, situacao, codigo_cliente, "
                + "vendedor, total_venda, desconto, observacao, codigo_documento) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            // Definindo os parâmetros da consulta
            stmt.setDate(1, new java.sql.Date(obj.getDataEmissao().getTime()));
            stmt.setDate(2, new java.sql.Date(obj.getValidade().getTime()));
            stmt.setString(3, obj.getFormaPagamento());
            stmt.setString(4, obj.getSituacao());
            stmt.setInt(5, obj.getCodigoCliente());
            stmt.setString(6, obj.getVendedor());
            stmt.setString(7, obj.getTotalVenda());
            stmt.setString(8, obj.getDesconto());
            stmt.setString(9, obj.getObservacao());
            stmt.setString(10, obj.getCodigoDocumento());

            stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("Erro ao adicionar orçamento: " + e.getMessage());
        }
    }

    // Método para listar todos os orçamentos
    public List<Orcamento> listarOrcamentos() {
        List<Orcamento> lista = new ArrayList<>();
        String sql = "SELECT * FROM tb_orcamento";

        try (PreparedStatement stmt = con.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Orcamento obj = new Orcamento();
                obj.setIdOrcamento(rs.getInt("id_orcamento"));
                obj.setDataEmissao(rs.getDate("data_emissao"));
                obj.setValidade(rs.getDate("validade"));
                obj.setFormaPagamento(rs.getString("forma_pagamento"));
                obj.setSituacao(rs.getString("situacao"));
                obj.setCodigoCliente(rs.getInt("codigo_cliente"));
                obj.setVendedor(rs.getString("vendedor"));
                obj.setTotalVenda(rs.getString("total_venda"));
                obj.setDesconto(rs.getString("desconto"));
                obj.setObservacao(rs.getString("observacao"));
                obj.setCodigoDocumento(rs.getString("codigo_documento"));

                lista.add(obj);
            }
        } catch (Exception e) {
            System.out.println("Erro ao listar orçamentos: " + e.getMessage());
        }
        return lista;
    }

    // Método para buscar um orçamento pelo ID
    public Orcamento buscarOrcamentoPorId(int idOrcamento) {
    Orcamento obj = null;
    String sql = "SELECT * FROM tb_orcamento WHERE id_orcamento = ?";

    try (PreparedStatement stmt = con.prepareStatement(sql)) {
        stmt.setInt(1, idOrcamento);

        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                obj = new Orcamento();
                obj.setIdOrcamento(rs.getInt("id_orcamento"));
                obj.setDataEmissao(rs.getDate("data_emissao"));
                obj.setValidade(rs.getDate("validade"));
                obj.setFormaPagamento(rs.getString("forma_pagamento"));
                obj.setSituacao(rs.getString("situacao"));
                obj.setCodigoCliente(rs.getInt("codigo_cliente"));
                obj.setVendedor(rs.getString("vendedor"));

                // Atualizando os campos de tipo double
                    obj.setTotalVenda(rs.getString("total_venda")); // Alterado para double
                    obj.setDesconto(rs.getString("desconto"));       // Alterado para double

                obj.setObservacao(rs.getString("observacao"));
                obj.setCodigoDocumento(rs.getString("codigo_documento"));
            }
        }
    } catch (Exception e) {
        System.out.println("Erro ao buscar orçamento por ID: " + e.getMessage());
    }
    return obj;
}


    // Método para atualizar um orçamento
    public void atualizarOrcamento(Orcamento obj) {
    String sql = "UPDATE tb_orcamento SET data_emissao = ?, validade = ?, forma_pagamento = ?, situacao = ?, "
               + "codigo_cliente = ?, vendedor = ?, total_venda = ?, desconto = ?, observacao = ?, codigo_documento = ?, documentacao = ? "
               + "WHERE id_orcamento = ?";

    try (PreparedStatement stmt = con.prepareStatement(sql)) {
        stmt.setDate(1, new java.sql.Date(obj.getDataEmissao().getTime()));
        stmt.setDate(2, new java.sql.Date(obj.getValidade().getTime()));
        stmt.setString(3, obj.getFormaPagamento());
        stmt.setString(4, obj.getSituacao());
        stmt.setInt(5, obj.getCodigoCliente());
        stmt.setString(6, obj.getVendedor());
        stmt.setString(7, obj.getTotalVenda());
        stmt.setString(8, obj.getDesconto());
        stmt.setString(9, obj.getObservacao());
        stmt.setString(10, obj.getCodigoDocumento());
        stmt.setString(11, obj.getDocumentacao()); // Atualiza o campo documentacao
        stmt.setInt(12, obj.getIdOrcamento());

        stmt.executeUpdate();
    } catch (Exception e) {
        System.out.println("Erro ao atualizar orçamento: " + e.getMessage());
    }
}


    // Método para excluir um orçamento
    public void excluirOrcamento(int idOrcamento) {
        String sql = "DELETE FROM tb_orcamento WHERE id_orcamento = ?";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, idOrcamento);
            stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("Erro ao excluir orçamento: " + e.getMessage());
        }
    }
}
