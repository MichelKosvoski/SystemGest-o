/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto.dao;

import br.com.projeto.jbdc.ConnectionFactory;
import br.com.projeto.model.ItemVenda;
import java.sql.Connection;
import java.sql.PreparedStatement;
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

            JOptionPane.showMessageDialog(null, "Item Registrada com Sucesso!");

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro:" + erro);
        }
    }

}


