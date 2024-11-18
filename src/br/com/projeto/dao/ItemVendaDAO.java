/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto.dao;

import br.com.projeto.jbdc.ConnectionFactory;
import br.com.projeto.model.ItemVenda;
import br.com.projeto.model.Produtos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class ItemVendaDAO {

    private Connection con;

    public ItemVendaDAO() {
        this.con = new ConnectionFactory().getConnection();

    }

    public void cadastraItem(ItemVenda obj) {
        try {
            String sql = "insert into tb_itensvendas(venda_id, produto_id, qtd, subtotal)values(?,?,?,?)";

            try (PreparedStatement stmt = con.prepareStatement(sql)) {

                stmt.setInt(1, obj.getVenda().getId());
                stmt.setInt(2, obj.getProduto().getId());
                stmt.setInt(3, obj.getQtd());
                stmt.setDouble(4, obj.getSubtotal());

                // 3 passo executar o comando sql]
                stmt.execute();
                stmt.close();
            }

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro:" + erro);
        }
    }

    // Metodo que lista itens vendidos de uma venda por id
    //metodo que filtra venda por data
public List<ItemVenda> listaItensPorVenda(int venda_id) {
    try {
        // Criando Lista
        List<ItemVenda> lista = new ArrayList<>();

        // Consulta SQL corrigida
        String query = "select i.id, p.descricao, i.qtd, p.preco, i.subtotal "
                     + "from tb_itensvendas as i "
                     + "inner join tb_produtos as p on (i.produto_id = p.id) "
                     + "where i.venda_id = ?";
        
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, venda_id);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            ItemVenda item = new ItemVenda();
            Produtos prod = new Produtos();
            
            // Mapeamento correto
            item.setId(rs.getInt("i.id"));
            prod.setDescricao(rs.getString("p.descricao"));
            item.setQtd(rs.getInt("i.qtd"));
            prod.setPreco(rs.getDouble("p.preco"));
            item.setSubtotal(rs.getDouble("i.subtotal"));
            
            // Associa o produto ao item
            item.setProduto(prod);

            // Adiciona o item à lista
            lista.add(item);
        }

        return lista;

    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
    }
}
