/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServletAl;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author yeray
 */
public class ServletAl extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletAl</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletAl at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
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
            ArrayList<Alumno> lista = new ArrayList<Alumno>();

        SQLConnection con = new SQLConnection();
        Connection conn = con.conectar();
        ResultSet rs = con.executequery("Select * from alumne", conn);

        try {
            while (rs.next()) {
                Alumno al = new Alumno(rs.getString("nom"), rs.getInt("codi"));
                lista.add(al);

            }
        } catch (SQLException ex) {
            Logger.getLogger(ServletAl.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("Arraylist", (ArrayList) lista);
        RequestDispatcher a = request.getRequestDispatcher("/index.jsp");

        a.forward(request, response);
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
               String codi = (String) request.getParameter("selector");
        String query = "select * from alumne where codi=" + codi;
        String auxilia = query;
        System.out.println(auxilia);
        response.setContentType("text/html;charset=UTF-8");

        SQLConnection con = new SQLConnection();
        Connection conn = con.conectar();
        ResultSet rsnombre = con.executequery(query, conn);

        ResultSet rs = con.executequery("select alumne.nom as nombre,alumne.codi as codigo,tutoria.nom as nomtutoria, assignatura.nom as nomassignatura"
                + " from alumne inner join tutoriaalumne on tutoriaalumne.codiAlumne= alumne.codi INNER join tutoria on tutoria.codi=tutoriaalumne.codiTutoria"
                + " INNER join assignatura on assignatura.codi=tutoria.codiAssignatura where alumne.codi=" + codi, conn);

        try {
            
                Alumno al = new Alumno();

                while (rs.next()) {
                    al.setNom(rs.getString("nombre"));
                    al.setCodi(rs.getInt("codigo"));
                    al.setAssignatures(rs.getString("nomassignatura"));
                    al.setTutories(rs.getString("nomtutoria"));

                }
                request.setAttribute("alumno", (Alumno) al);
                RequestDispatcher a = request.getRequestDispatcher("/Response.jsp");
                a.forward(request, response);
               
                 } catch (SQLException ex) {
            Logger.getLogger(ServletAl.class.getName()).log(Level.SEVERE, null, ex);
        }
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
