/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author khwarizmi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dao.DaoPost;
import entities.Post;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author khwarizmi
 */
public class PostController extends HttpServlet {

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
        switch(acao){
            case "postar":
                int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
                String conteudo = request.getParameter("conteudo");
                Post post = new Post(0, idUsuario, null, conteudo, 0);
                DaoPost dPost = new DaoPost();
                
        
        if(dPost.add(post) == true){
           request.getRequestDispatcher("index.jsp")
                .forward(request, response);
        }else{
           request.setAttribute("mensagem", "Erro no cadastro"); 
           request.getRequestDispatcher("confirmacaocadastro.jsp")
                   .forward(request, response);
        }
        
        break;
        }
        /*{
               
        List<Post> lstPost = (List<Post>)(List<?>) new DaoPost().findAll();
        
        request.setAttribute("lstUsuarios", lstPost);
        request.getRequestDispatcher("listarusuarios.jsp")
                .forward(request, response);
        
        }else if(acao.equalsIgnoreCase("excluir")){
            int id = Integer.parseInt(request.getParameter("id"));
            new DaoPost().delete(id);
            response.sendRedirect("PostControlle?acao=listar");
           }*/
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
