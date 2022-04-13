package control;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.Consumo;
import model.DAO;

/**
 *
 * @author root
 */

public class UpdateServlet extends HttpServlet{
    protected void print_form(PrintWriter out, Consumo c){
        out.println("<form action=\"InserirServlet\" method=\"get\">");
        out.println("Data: <input value = \"" + c.getDate() + "\" type=\"text\" name=\"date\"><br>");
        out.println("Tipo de Combustível: <input value = \"" + c.getType() + "\" type=\"text\" name=\"type\"><br>");
        out.println("Quantidade em litros(l): <input value = \"" + c.getFuel() + "\" type=\"text\" name=\"fuel\"><br>");
        out.println("Distância percorrida(km): <input value = \"" + c.getKilometers() + "\" type=\"text\" name=\"kilometers\"><br>");
        out.println("<input type=\"submit\">");
        out.println("</form>");
    }

    protected void print_form(PrintWriter out){
        out.println("<form action=\"InserirServlet\" method=\"get\">");
        out.println("Data: <input type=\"text\" name=\"date\"><br>");
        out.println("Tipo de Combustível: <input type=\"text\" name=\"type\"><br>");
        out.println("Quantidade em litros(l): <input type=\"text\" name=\"fuel\"><br>");
        out.println("Distância percorrida(km): <input type=\"text\" name=\"kilometers\"><br>");
        out.println("<input type=\"submit\">");
        out.println("</form>");
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            Enumeration<String> retornoGetParameterNames = request.getParameterNames();
            int index = Integer.parseInt(retornoGetParameterNames.nextElement());
            if(index != -1){
                Consumo current_consumo = new Consumo();
                List<Consumo> consumos = DAO.read();
                current_consumo = consumos.get(index);
                print_form(out, current_consumo);
            }
            else {
                print_form(out);
            }
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
