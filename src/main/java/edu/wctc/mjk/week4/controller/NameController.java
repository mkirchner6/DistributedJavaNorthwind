/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wctc.mjk.week4.controller;

import edu.wctc.mjk.week4.model.Name;
import edu.wctc.mjk.week4.model.NameService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mattkirchner
 */
public class NameController extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NameController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NameController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        NameService nameService = new NameService();
        RequestDispatcher dispatch = null;
        
        String id = request.getParameter("id");
        String search = request.getParameter("search");
        
        if (id != null){
            Name name = nameService.getName(id);
            request.setAttribute("name", name);
            dispatch = request.getRequestDispatcher("/WEB-INF/NameDetail.jsp");
        } else if(search != null) {
            List<Name> nameList = nameService.findNames(search);
            request.setAttribute("nameList", nameList);
            dispatch = request.getRequestDispatcher("/WEB-INF/NameList.jsp");
        } else {
            List<Name> nameList = nameService.getAllNames();
            request.setAttribute("nameList", nameList);
            dispatch = request.getRequestDispatcher("/WEB-INF/NameList.jsp");
        }
        
        dispatch.forward(request, response);
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
    }

}
