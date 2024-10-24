/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto.dao;

import br.com.projeto.jbdc.ConnectionFactory;
import br.com.projeto.model.Vendas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class VendasDAO {

    private Connection con;

    public VendasDAO() {
        this.con = new ConnectionFactory().getConnection();

    }

    //Cadastrar Vendas
    public void cadastrarVenda(Vendas obj) {
        try {
            String sql = "insert into tb_vendas(cliente_id, data_venda, total_venda, observacoes)values(?,?,?,?)";

            try (PreparedStatement stmt = con.prepareStatement(sql)) {

                stmt.setInt(1, obj.getCliente().getId());
                stmt.setString(2, obj.getData_venda());
                stmt.setDouble(3, obj.getTotal_venda());
                stmt.setString(4, obj.getObs());

                // 3 passo executar o comando sql]
                stmt.execute();
                stmt.close();
            }

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro:" + erro);
        }
    }

    //Retornar uma venda
    public int retornarUltimaVenda() {
        try {
            int idvenda = 0;
            String sql = "select max(id) id from tb_vendas";
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Vendas p = new Vendas();

                p.setId(rs.getInt("id"));

                idvenda = p.getId();
            }

            return idvenda;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        }


    
}

