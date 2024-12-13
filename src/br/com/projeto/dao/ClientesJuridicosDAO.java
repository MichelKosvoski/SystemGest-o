/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto.dao;

import br.com.projeto.jbdc.ConnectionFactory;
import br.com.projeto.model.ClientesJuridicos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * Classe para realizar operações no banco de dados relacionadas aos clientes
 * jurídicos.
 */
public class ClientesJuridicosDAO {

    private final Connection con;

    public ClientesJuridicosDAO() {
        // Estabelecendo a conexão com o banco
        this.con = new ConnectionFactory().getConnection();
    }

    /**
     * Método para cadastrar cliente jurídico.
     *
     * @param cliente Objeto ClientesJuridicos a ser cadastrado
     */
    public void cadastrarCliente(ClientesJuridicos cliente) {
        String sql = "INSERT INTO tb_clientes_juridicos (razao_social, nome_fantasia, cnpj, email, telefone, celular, cep, endereco, numero, complemento, bairro, cidade, estado, data_cadastro) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, cliente.getRazaoSocial());
            stmt.setString(2, cliente.getNomeFantasia());
            stmt.setString(3, cliente.getCnpj());
            stmt.setString(4, cliente.getEmail());
            stmt.setString(5, cliente.getTelefone());
            stmt.setString(6, cliente.getCelular());
            stmt.setString(7, cliente.getCep());
            stmt.setString(8, cliente.getEndereco());
            stmt.setInt(9, cliente.getNumero());
            stmt.setString(10, cliente.getComplemento());
            stmt.setString(11, cliente.getBairro());
            stmt.setString(12, cliente.getCidade());
            stmt.setString(13, cliente.getEstado());

            // Verifique o tipo de cliente.getDataCadastro()
            Object dataCadastro = cliente.getDataCadastro();
            if (dataCadastro instanceof java.time.LocalDate) {
                java.sql.Date sqlDate = java.sql.Date.valueOf((java.time.LocalDate) dataCadastro);
                stmt.setDate(14, sqlDate);
            } else if (dataCadastro instanceof java.util.Date) {
                stmt.setDate(14, new java.sql.Date(((java.util.Date) dataCadastro).getTime()));
            } else {
                throw new IllegalArgumentException("Tipo de data não suportado: " + dataCadastro.getClass().getName());
            }

            stmt.execute();
            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar cliente: " + e.getMessage());
        }
    }

    /**
     * Método para listar todos os clientes jurídicos.
     *
     * @return Lista de ClientesJuridicos
     */
    public List<ClientesJuridicos> listarClientesPJ() {
        List<ClientesJuridicos> lista = new ArrayList<>();
        String sql = "SELECT * FROM tb_clientes_juridicos";

        try (PreparedStatement stmt = con.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                ClientesJuridicos cliente = new ClientesJuridicos();
                cliente.setId(rs.getInt("id"));
                cliente.setRazaoSocial(rs.getString("razao_social"));
                cliente.setNomeFantasia(rs.getString("nome_fantasia"));
                cliente.setCnpj(rs.getString("cnpj"));
                cliente.setEmail(rs.getString("email"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setCelular(rs.getString("celular"));
                cliente.setCep(rs.getString("cep"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setNumero(rs.getInt("numero"));
                cliente.setComplemento(rs.getString("complemento"));
                cliente.setBairro(rs.getString("bairro"));
                cliente.setCidade(rs.getString("cidade"));
                cliente.setEstado(rs.getString("estado"));
                // Verifique o tipo de cliente.setDataCadastro() e ajuste
                java.sql.Date sqlDate = rs.getDate("data_cadastro");
                if (sqlDate != null) {
                    // Exemplo para java.time.LocalDate
                    cliente.setDataCadastro(sqlDate.toLocalDate());
                    // Ou para java.util.Date
                    // cliente.setDataCadastro(new java.util.Date(sqlDate.getTime()));
                    // Ou se já espera java.sql.Date
                    // cliente.setDataCadastro(sqlDate);
                }

                lista.add(cliente);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar clientes: " + e.getMessage());
        }
        return lista;
    }

    /**
     * Método para atualizar cliente jurídico.
     *
     * @param cliente Objeto ClientesJuridicos com dados atualizados
     */
    public void atualizarCliente(ClientesJuridicos cliente) {
        String sql = "UPDATE tb_clientes_juridicos SET razao_social=?, nome_fantasia=?, cnpj=?, email=?, telefone=?, celular=?, cep=?, endereco=?, numero=?, complemento=?, bairro=?, cidade=?, estado=?, data_cadastro=? WHERE id=?";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, cliente.getRazaoSocial());
            stmt.setString(2, cliente.getNomeFantasia());
            stmt.setString(3, cliente.getCnpj());
            stmt.setString(4, cliente.getEmail());
            stmt.setString(5, cliente.getTelefone());
            stmt.setString(6, cliente.getCelular());
            stmt.setString(7, cliente.getCep());
            stmt.setString(8, cliente.getEndereco());
            stmt.setInt(9, cliente.getNumero());
            stmt.setString(10, cliente.getComplemento());
            stmt.setString(11, cliente.getBairro());
            stmt.setString(12, cliente.getCidade());
            stmt.setString(13, cliente.getEstado());
            stmt.setInt(15, cliente.getId());
            Object dataCadastro = cliente.getDataCadastro();
            if (dataCadastro instanceof java.time.LocalDate) {
                java.sql.Date sqlDate = java.sql.Date.valueOf((java.time.LocalDate) dataCadastro);
                stmt.setDate(14, sqlDate);
            } else if (dataCadastro instanceof java.util.Date) {
                stmt.setDate(14, new java.sql.Date(((java.util.Date) dataCadastro).getTime()));
            } else {
                throw new IllegalArgumentException("Tipo de data não suportado: " + dataCadastro.getClass().getName());
            }

            stmt.execute();
            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar cliente: " + e.getMessage());
        }
    }

    /**
     * Método para excluir cliente jurídico.
     *
     * @param id ID do cliente a ser excluído
     */
    public void excluirCliente(int id) {
        String sql = "DELETE FROM tb_clientes_juridicos WHERE id=?";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir cliente: " + e.getMessage());
        }
    }
}
