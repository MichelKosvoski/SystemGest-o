/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto.dao;

import br.com.projeto.jbdc.ConnectionFactory;
import br.com.projeto.model.Fornecedores;
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
public class ProdutosDAO {

    private Connection con;

    public ProdutosDAO() {
        this.con = new ConnectionFactory().getConnection();
    }

    //Metodo Cadastrar
    public void cadastrar(Produtos obj) {
        try {

            String sql = "insert into tb_produtos(descricao, preco, qtd_estoque, for_id)values(?,?,?,?)";

            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setString(1, obj.getDescricao());
                stmt.setDouble(2, obj.getPreco());
                stmt.setInt(3, obj.getQtd_estoque());
                stmt.setInt(4, obj.getFornecedor().getId());

                // 3 passo executar o comando sql]
                stmt.execute();
                stmt.close();
            }

            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro:" + erro);
        }

    }

    public List<Produtos> listarProdutos() {
        try {

            List<Produtos> listar = new ArrayList<>();

            String sql = "select p.id, p.descricao, p.preco, p.qtd_estoque, f.nome from tb_produtos as p "
                       + "inner join tb_fornecedores as f on(p.for_id = f.id)";

            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Produtos obj = new Produtos();
                Fornecedores f = new Fornecedores();
                obj.setId(rs.getInt("p.id"));
                obj.setDescricao(rs.getString("p.descricao"));
                obj.setPreco(rs.getDouble("p.preco"));
                obj.setQtd_estoque(rs.getInt("p.qtd_estoque"));

                f.setNome(rs.getString("f.nome"));

                obj.setFornecedor(f);

                listar.add(obj);
            }
            return listar;

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro:" + erro);

            return null;
        }
    }

    public void alterarProdutos(Produtos obj) {
        try {
            String sql = "update tb_fornecedores set descricao=?, preco=?, qtd_estoque=?, for_id=? where id=?";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getDescricao());
            stmt.setDouble(2, obj.getPreco());
            stmt.setInt(3, obj.getQtd_estoque());
            stmt.setInt(4, obj.getFornecedor().getId());
            stmt.setInt(5, obj.getId());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Alterado com Sucesso!");

        } catch (Exception erro) {

            JOptionPane.showMessageDialog(null, "Erro:" + erro);

        }
    }

    public void deletarProdutos(Produtos obj) {

        try {

            String sql = "delete from tb_produtos where id = ?";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, obj.getId());

            // 3 passo executar o comando sql]
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Deletado com sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro:" + erro);

        }

    }

}