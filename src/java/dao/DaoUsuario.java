/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Entitie;
import entities.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author khwarizmi
 */
public class DaoUsuario extends Dao implements DaoFunctions{

    @Override
    public boolean add(Entitie entitie) {
        Usuario usu = (Usuario) entitie;
        String comando = "insert into usuarios (nome, email, senha) values (?,?,?)";
        try{
            this.conectar();
            this.stmt = this.conn.prepareStatement(comando);
            this.stmt.setString(1,usu.getNome());
            this.stmt.setString(3,usu.getEmail());
            this.stmt.setString(4,usu.getSenha());
            this.stmt.execute();
        }catch(SQLException ex){
            System.out.println("Erro ao inserir Usuário"+ex.getMessage());
            return false;
        }
        return true;
    }
    
    @Override
    public boolean delete(int id) {
      String comando = "delete from usuarios where id =?";
        try{
            this.conectar();
            this.stmt = this.conn.prepareStatement(comando);
            this.stmt.setInt(1,id);
            this.stmt.execute();
        }catch(SQLException ex){
            System.out.println("Erro ao deletar Usuário"+ex.getMessage());
            return false;
        }
        return true;  
       
    }
    
    @Override
    public boolean update(Entitie entitie) {
        Usuario usu = (Usuario) entitie;
        String comando = "update usuarios set nome = ?, email = ?, senha = ? where id =?";
        try{
            this.conectar();
            this.stmt = this.conn.prepareStatement(comando);
            this.stmt.setString(1,usu.getNome());
            this.stmt.setString(3,usu.getEmail());
            this.stmt.setString(4,usu.getSenha());
            this.stmt.setInt(5,usu.getId());
            this.stmt.execute();
        }catch(SQLException ex){
            System.out.println("Erro ao atualizar Usuário"+ex.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public Entitie find(int id) {
         String comando = "Select * from usuarios where id = ?";
        try{
            this.conectar();
            this.stmt = this.conn.prepareStatement(comando);
            this.stmt.setInt(1, id);
            ResultSet rs = this.stmt.executeQuery();
            if(rs.next()){
                 Usuario usu  = new Usuario();
                 usu.setId(rs.getInt("id"));
                 usu.setNome(rs.getString("nome"));
                 usu.setEmail(rs.getString("email"));
                 return usu;
            }
        }catch(SQLException ex){
            return null;
        }
        return null;
    }
    
    @Override
    public List<Entitie> findAll() {
        String comando = "Select * from usuarios";
        List<Entitie> lstUsuarios = new ArrayList<>();
    
        try{
            this.conectar();
            this.stmt = this.conn.prepareStatement(comando);
            ResultSet rs = this.stmt.executeQuery();
            while(rs.next()){
                 Usuario usu  = new Usuario();
                 usu.setId(rs.getInt("id"));
                 usu.setNome(rs.getString("nome"));
                 usu.setEmail(rs.getString("email"));
                 lstUsuarios.add(usu);
            }
        }catch(SQLException ex){
            return null;
        }
        return lstUsuarios;
    }
   
    public Usuario efetuarLogin(String email, String senha) throws SQLException{
        String comando = "Select * from usuários where email = ? and senha = ?";
        try{
            this.conectar();
            this.stmt = this.conn.prepareStatement(comando);
            this.stmt.setString(1, senha);
            this.stmt.setString(2, senha);
            ResultSet rs = this.stmt.executeQuery();
            if(rs.next()){
                Usuario usu = new Usuario();
                usu.setId(rs.getInt("id"));
                usu.setNome(rs.getString("nome"));
                usu.setEmail(rs.getString("email"));
            }
        }catch(SQLException ex){
            return null;
        }
     return null;
    }
}
