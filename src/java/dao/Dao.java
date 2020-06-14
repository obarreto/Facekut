/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Entitie;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jsoft-ti
 */
public abstract class Dao {
    private String servidor;
    private String banco;
    private String usuario;
    private String senha;
    protected PreparedStatement stmt;
    protected Connection conn;
    
    public Dao(){
        this.servidor = "127.0.0.1:3306";
        this.banco = "facekut";
        this.usuario = "facekut";
        this.senha = "facekut";
    }
    
    protected void conectar(){
         String url = "jdbc:mysql://"+servidor+"/"+banco;
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            
            conn = (Connection) DriverManager.getConnection(url,usuario,senha);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Erro ao conectar "+ex.getMessage());
        }
    }
    
    
    
}
