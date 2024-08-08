/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto.dao;

import br.com.projeto.jbdc.ConnectionFactory;
import br.com.projeto.model.Clientes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

/**
 *
 * @author User
 */
public class ClientesDAO {
    // Metodo cadastrarCliente

    private Connection con;

    public ClientesDAO(Connection con) {
        this.con = con;
    }

    public ClientesDAO() {
        this.con = (Connection) new ConnectionFactory().getConnection();
    }

    public void cadastrarCliente(Clientes obj) {
        try {

            String sql = "insert into tb_clientes (nome, rg, cpf, email, telefone, celular, cep,endereco, numero, complemento, bairro, cidade, estado)"
                    + "values (?,?,?,?,?,?,?,?,?,?,?,?,?)";

            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setString(1, obj.getNome());
                stmt.setString(2, obj.getRg());
                stmt.setString(3, obj.getCpf());
                stmt.setString(4, obj.getEmail());
                stmt.setString(5, obj.getTelefone());
                stmt.setString(6, obj.getCelular());
                stmt.setString(7, obj.getCep());
                stmt.setString(8, obj.getEndereco());
                stmt.setString(9, obj.getNumero());
                stmt.setString(10, obj.getComplemento());
                stmt.setString(11, obj.getBairro());
                stmt.setString(12, obj.getCidade());
                stmt.setString(13, obj.getEstado());

                // 3 passo executar o comando sql]
                stmt.execute();
            }

            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro:" + erro);

        }

    }

    // Metodo alterarCliente
    public void alterarCliente(Clientes obj) {
        
        try {

            String sql = "update tb_clientes set nome=?, rg=?, cpf=?, email=?, telefone=?, celular=?, cep=?,"
                        + "endereco=?, numero?, complemento?, bairro?, cidade?, estado? where id =?";

            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setString(1, obj.getNome());
                stmt.setString(2, obj.getRg());
                stmt.setString(3, obj.getCpf());
                stmt.setString(4, obj.getEmail());
                stmt.setString(5, obj.getTelefone());
                stmt.setString(6, obj.getCelular());
                stmt.setString(7, obj.getCep());
                stmt.setString(8, obj.getEndereco());
                stmt.setString(9, obj.getNumero());
                stmt.setString(10, obj.getComplemento());
                stmt.setString(11, obj.getBairro());
                stmt.setString(12, obj.getCidade());
                stmt.setString(13, obj.getEstado());
                
                stmt.setInt(14, obj.getId());

                // 3 passo executar o comando sql]
                stmt.execute();
            }

            JOptionPane.showMessageDialog(null, "Alterado com sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro:" + erro);

        }

    }

    // Metodo deletarCliente
    public void deletarCliente(Clientes obj) {
        
        try {

            String sql = "delete from tb_clientes where id = ?";

            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setInt(1, obj.getId());
           
                // 3 passo executar o comando sql]
                stmt.execute();
            }

            JOptionPane.showMessageDialog(null, "Deletado com sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro:" + erro);

        }
        
    }

    // Metodo de Listar Todos os Clientes
    public List<Clientes> listarClientes() {

        try {
            //Cliando Lista
            List<Clientes> lista = new ArrayList<>();

            // Comando SQL
            String sql = "select * from tb_clientes";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Clientes obj = new Clientes();

                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setTelefone(rs.getString("Telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("Endereco"));
                obj.setNumero(rs.getString("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setUf(rs.getString("estado"));

                lista.add(obj);

            }

            return lista;

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "Erro:" + erro);
            return null;
        }
    }

}
