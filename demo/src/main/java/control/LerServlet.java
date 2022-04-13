package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.Consumo;
import model.DAO;

public class LerServlet extends HttpServlet{

    private void print_consumo(PrintWriter out, Consumo c, int index){
        out.println("<tr>");
        out.println("<td> " + c.getDate() + "</td>");
        out.println("<td> " + c.getType() + "</td>");
        out.println("<td> " + c.getFuel() + "</td>");
        out.println("<td> " + c.getKilometers() + "</td>");
        out.println("<td> " + c.getRendimento() + "</td>");
        out.println("<td> <button name = \"" + index + "\"type=\"submit\" formaction = \"UpdateServlet\"> Atualizar</button> </td>");
        out.println("<td> <button name = \"" + index + "\" type=\"submit\" formaction = \"DeletarServlet\"> Deletar</button> </td>");
        out.println("</tr>");
    }

    private void print_head(PrintWriter out){
        out.println("<tr>");
        out.println("<th>Data</th>");
        out.println("<th>Tipo</th>");
        out.println("<th>Combustível(l)</th>");
        out.println("<th>Quilometragem percorrida(km)</th>");
        out.println("<th>Rendimento(km/l)</th>");
        out.println("</tr>");
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<form>");
            out.println("<table>");
            print_head(out);
            List<Consumo> consumos = DAO.read();
            for (int i = 0; i < consumos.size(); i++){
                Consumo c = consumos.get(i);
                print_consumo(out, c, i);
            }
            out.println("</table>");
            out.println("<button type=\"submit\" name = \"-1\"formaction = \"UpdateServlet\"> Inserir novo</button>");
            out.println("</form>");
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
