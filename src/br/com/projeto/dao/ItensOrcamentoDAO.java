/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto.dao;

import br.com.projeto.jbdc.ConnectionFactory;
import br.com.projeto.model.ItensOrcamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ItensOrcamentoDAO {

    private Connection con;

    public ItensOrcamentoDAO() {
        this.con = new ConnectionFactory().getConnection();
    }

    // Método para adicionar um item ao orçamento
    public void adicionarItem(ItensOrcamento obj) {
        String sql = "INSERT INTO tb_itens_orcamento (id_orcamento, codigo_produto, qtd, preco_unitario, subtotal) "
                   + "VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            // Definindo os parâmetros da consulta
            stmt.setInt(1, obj.getIdOrcamento());
            stmt.setInt(2, obj.getCodigoProduto());
            stmt.setInt(3, obj.getQtd());
            stmt.setDouble(4, obj.getPrecoUnitario());
            stmt.setDouble(5, obj.getSubtotal());

            // Executando a inserção
            stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("Erro ao adicionar item no orçamento: " + e.getMessage());
        }
    }

    // Método para listar todos os itens de um orçamento
    public List<ItensOrcamento> listarItensPorOrcamento(int idOrcamento) {
        List<ItensOrcamento> lista = new ArrayList<>();
        String sql = "SELECT * FROM tb_itens_orcamento WHERE id_orcamento=?";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, idOrcamento);

            try (ResultSet rs = stmt.executeQuery()) {
                // Processando os resultados
                while (rs.next()) {
                    ItensOrcamento obj = new ItensOrcamento();
                    obj.setIdItem(rs.getInt("id_item"));
                    obj.setIdOrcamento(rs.getInt("id_orcamento"));
                    obj.setCodigoProduto(rs.getInt("codigo_produto"));
                    obj.setQtd(rs.getInt("qtd"));
                    obj.setPrecoUnitario(rs.getDouble("preco_unitario"));
                    obj.setSubtotal(rs.getDouble("subtotal"));

                    lista.add(obj);
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao listar itens do orçamento: " + e.getMessage());
        }
        return lista;
    }
}

