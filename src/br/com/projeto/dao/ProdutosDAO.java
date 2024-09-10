/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto.dao;

import br.com.projeto.jbdc.ConnectionFactory;
import java.sql.Connection;

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
    public void cadastrar(Produtos obj){
        try {
            
            string sql = "insert intro tb_"
            
            
        } catch (Exception e) {
        }
        
    }
}

