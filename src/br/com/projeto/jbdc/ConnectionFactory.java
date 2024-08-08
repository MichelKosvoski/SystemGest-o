/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto.jbdc;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author User
 */
public class ConnectionFactory {
    
    public Connection getConnection() {
        
        try {
            
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbvendas?user=postgres&password=root");
            
        } catch (Exception erro) {
            throw new RuntimeException(erro);
        }
    }
}
