/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import EJB.AccountSessionBeanRemote;
import EJB.ClientSessionBeanRemote;
import Entity.Account;
import Entity.Client;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.persistence.EntityManager;
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
@WebServlet(name = "AccountSessionBeanEJB", urlPatterns = {"/AccountSessionBeanEJB"})
public class AccountSessionBeanEJB extends HttpServlet {

    @EJB
    AccountSessionBeanRemote accountbean;
    ClientSessionBeanRemote clientbean;
    EntityManager em;

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
            /* TODO output your page here. You may use following sample code. */
            HttpSession session = request.getSession(true);

            //Client c = clientbean.getClientById(clientid);
            //accountbean.addAccount(a);
            Long clientid = (Long) session.getAttribute("id"); 
            System.out.println(clientid);                      
            //try {
            Account a = new Account(request.getParameter("accname"), Integer.parseInt(request.getParameter("money")));
             //Account a = new Account("SEX123", 777);
            Client c = em.find(Client.class, clientid); //em.find(Client.class, clientid);
            a.setClient(c);
            accountbean.addAccount(a);
            
            
            //em.merge(a);      
            //em.flush();
            //} catch (NullPointerException e) {System.out.println("rew");}
            //System.out.println (c);

            //em.persist(a);
            //em.flush();
            //em.getTransaction( ).commit( );
            //em.close();
            //
            //Client c = Client.getClientById
            /* Account a=new Account("KZ1",500);
            Account b = new Account("KZ2",1500);
            em.persist(a);
            em.persist(b);
            em.flush();
            a.setClient(c);
            b.setClient(c);
            em.merge(a);
            em.merge(b);
            em.flush(); */
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
