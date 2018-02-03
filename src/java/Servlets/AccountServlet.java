/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Entity.Account;
import Entity.Client;
import java.io.IOException;
import java.io.PrintWriter;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author user
 */
@WebServlet(name = "AccountServlet", urlPatterns = {"/AccountServlet"})
public class AccountServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession session =request.getSession(true);  //Как сделать чтобы не создавать нового пользователя а брать текущего и связывать с новым счетом. Пробую через сесиию
            Long clientId = (Long) session.getAttribute("id");
            System.out.println (clientId);
            /* TODO output your page here. You may use following sample code. */
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("BankingJPAPU");
            EntityManager em = emf.createEntityManager();
//            em.getTransaction().begin();  //28.12 ybral
            
           // System.out.println(clientId);
            
            Client c = em.find(Client.class, clientId);
            
            
            //c.setLogin(request.getParameter("login"));
            //c.setPassword(request.getParameter("pass"));
            //c.setFirstname(request.getParameter ("firstname"));
            //c.setLastname(request.getParameter("lastname"));
            
            //Account acc = new Account(request.getParameter("accname"),Integer.parseInt(request.getParameter("money")));//("USD999", 1000000);
            Account acc = new Account ("USD999222", 1000000);
            acc.setClient(c);
            em.persist(acc);
            em.flush(); //03.12 добавил
             
            em.merge(acc);
            em.flush();
            //em.getTransaction( ).commit( ); //28.12 ybral
            em.close();
            emf.close();
            
            
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
