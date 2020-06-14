/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;
import java.time.LocalDateTime;
/**
 *
 * @author khwarizmi
 */
public class Post extends Entitie{
       private int id;
       private int idUsuario;
       private LocalDateTime data;
       private String conteudo;
       private int qtdCurtidas;

    public Post(int id, int idUsuario, LocalDateTime data, String conteudo, int qtdCurtidas) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.data = data;
        this.conteudo = conteudo;
        this.qtdCurtidas = qtdCurtidas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public int getQtdCurtidas() {
        return qtdCurtidas;
    }

    public void setQtdCurtidas(int qtdCurtidas) {
        this.qtdCurtidas = qtdCurtidas;
    }
       
}
