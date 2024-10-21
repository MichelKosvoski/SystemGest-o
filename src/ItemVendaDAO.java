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

public class ItenVendaDAO {
    private Connection con;

    public ItenVendaDAO() {
        this.con = new ConnectionFactory().getConnection();
    }
}

//Metodo que cadastra Itens
public void cadastraIten(ItenVenda obj){

}
