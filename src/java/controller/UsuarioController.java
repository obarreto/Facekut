/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DaoUsuario;
import entities.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author khwarizmi
 */
public class UsuarioController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acao = request.getParameter("acao");
        if(acao.equalsIgnoreCase("cadastrar")){
            
            String nome  = request.getParameter("nome");
            String email = request.getParameter("email");
            String senha = request.getParameter("senha");
        
        DaoUsuario dUsuario = new DaoUsuario();
        Usuario usu = new Usuario(0, nome, email, senha);
        
        if(dUsuario.add(usu) == true){
           request.setAttribute("mensagem", "Cadastro realizado com sucesso");
 
        }else{
           request.setAttribute("mensagem", "Erro no cadastro"); 
        }
        
        request.getRequestDispatcher("confirmacaocadastro.jsp")
                .forward(request, response);
        
        }else if(acao.equalsIgnoreCase("lista")){
               
        List<Usuario> lstUsuario = (List<Usuario>)(List<?>) new DaoUsuario().findAll();
        
        request.setAttribute("lstUsuarios", lstUsuario);
        request.getRequestDispatcher("listarusuarios.jsp")
                .forward(request, response);
        
        }else if(acao.equalsIgnoreCase("excluir")){
            int id = Integer.parseInt(request.getParameter("id"));
            new DaoUsuario().delete(id);
            response.sendRedirect("UsuarioControlle?acao=listar");
           }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
