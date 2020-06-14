/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Entitie;
import entities.Post;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import java.time.ZoneId;
/**
 *
 * @author khwarizmi
 */
public class DaoPost extends Dao implements DaoFunctions{
    @Override
    public boolean add(Entitie entitie) {
        Post post = (Post) entitie;
        String comando = "insert into usuarios (id, idUsuario, conteudo, qtdCurtidas) values (?,?,?,?)";
        try{
            this.conectar();
            this.stmt = this.conn.prepareStatement(comando);
            this.stmt.setInt(1,post.getId());
            this.stmt.setInt(2,post.getIdUsuario());
            //this.stmt.set(3,post.getData());
            this.stmt.setString(3,post.getConteudo());
            this.stmt.setInt(4,post.getQtdCurtidas());
            this.stmt.execute();
        }catch(SQLException ex){
            System.out.println("Erro ao inserir Usuário"+ex.getMessage());
            return false;
        }
        return true;
    }
    
    @Override
    public boolean delete(int id) {
      String comando = "delete from posts where id =?";
        try{
            this.conectar();
            this.stmt = this.conn.prepareStatement(comando);
            this.stmt.setInt(1,id);
            this.stmt.execute();
        }catch(SQLException ex){
            System.out.println("Erro ao deletar Post"+ex.getMessage());
            return false;
        }
        return true;  
       
    }
    
    @Override
    public boolean update(Entitie entitie) {
        /*Post post = (Post) entitie;
        String comando = "update usuarios set id = ? , idUsuario = ?, conteudo = ?, qtdCurtidas = ? where id = ?";
        try{
            this.conectar();
            this.stmt = this.conn.prepareStatement(comando);
            this.stmt.setInt(1,post.getId());
            this.stmt.setInt(2,post.getIdUsuario());
            //this.stmt.set(3,post.getData());
            this.stmt.setString(3,post.getConteudo());
            this.stmt.setInt(4,post.getQtdCurtidas());
            this.stmt.execute();
        }catch(SQLException ex){
            System.out.println("Erro ao atualizar Usuário"+ex.getMessage());
            return false;
        }
        return true;*/
        throw new UnsupportedOperationException("Not suppoted yet.");
    }

    @Override
    public Entitie find(int id) {
         /*String comando = "Select * from usuarios where id = ?";
        try{
            this.conectar();
            this.stmt = this.conn.prepareStatement(comando);
            this.stmt.setInt(1, id);
            ResultSet rs = this.stmt.executeQuery();
            if(rs.next()){
                 Post post  = new Post(id, id, LocalDateTime.MAX, comando, id);
                 post.setId(rs.getInt("id"));
                 usu.setNome(rs.getString("nome"));
                 usu.setEmail(rs.getString("email"));
                 return usu;
            }
        }catch(SQLException ex){
            return null;
        }
        return null*/
         throw new UnsupportedOperationException("Not suppoted yet.");
    }
    
    @Override
    public List<Entitie> findAll() {
        String comando = "Select * from usuarios";
        List<Entitie> lstPosts = new ArrayList<>();
    
        try{
            this.conectar();
            this.stmt = this.conn.prepareStatement(comando);
            ResultSet rs = this.stmt.executeQuery();
            while(rs.next()){
                 
                int id = rs.getInt("id");
                int idUsuario = rs.getInt("idUsuario");
                LocalDateTime data = rs.getDate("data").toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
                String conteudo = rs.getString("conteudo");
                int qtdCurtidas = rs.getInt("qtdCurtidas");
                Post post = new Post(id, idUsuario, data, conteudo, qtdCurtidas);
                 
                 lstPosts.add(post);
            }
        }catch(SQLException ex){
            return null;
        }
        return lstPosts;
    }
   
   /* public Post efetuarLogin(String email, String senha) throws SQLException{
        String comando = "Select * from usuários where email = ? and senha = ?";
        try{
            this.conectar();
            this.stmt = this.conn.prepareStatement(comando);
            this.stmt.setString(1, senha);
            this.stmt.setString(2, senha);
            ResultSet rs = this.stmt.executeQuery();
            if(rs.next()){
                Post post = new Post(0, 0, LocalDateTime.MAX, comando, 0);
                post.setId(rs.getInt("id"));
                post.setNome(rs.getString("nome"));
                post.setEmail(rs.getString("email"));
            }
        }catch(SQLException ex){
            return null;
        }
        
    }*/
}

    

