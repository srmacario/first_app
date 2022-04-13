package control;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
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


public class InserirServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String current_date = request.getParameter("date");
            String current_type = request.getParameter("type");
            String current_fuel = request.getParameter("fuel");
            String current_kilometers = request.getParameter("kilometers");
            
            Consumo novo_consumo = new Consumo(current_date, current_type, Double.parseDouble(current_fuel), Double.parseDouble(current_kilometers));

            //Retrieve list from json
            int index = -1;
            List<Consumo> consumos = DAO.read();
            //Verifica se ja existe
            for (int i = 0; i < consumos.size(); i++){
                Consumo c = consumos.get(i);
                if(c.getDate().equals(novo_consumo.getDate())) index = i;
            }
            //Insert consumo in list
            if(index == -1){
                //CREATE
                consumos.add(novo_consumo);
            }
            else{
                //UPDATE
                consumos.set(index, novo_consumo);
            }
            DAO.update(consumos);

            RequestDispatcher rd = request.getRequestDispatcher("LerServlet");
            rd.forward(request, response);
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
