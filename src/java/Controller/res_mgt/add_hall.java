/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.res_mgt;

import data.DBInsertDeleteHandler;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.foundation.Department;
import model.foundation.Hall;

/**
 *
 * @author Pamoda
 */
public class add_hall extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("start<br>");
            Hall v = new Hall();
            v.setCapacityAmount(Integer.parseInt(request.getParameter("capacity")));
            v.setDescription(request.getParameter("description"));
            v.setCategory("Hall");
            v.setResourceName(request.getParameter("resource_name"));
            v.setAirConditioned(request.getParameter("ac").equals("Yes") ? true : false);
            v.setProjectorAvailable(request.getParameter("pro").equals("Yes") ? true : false);
            v.setBoardType(request.getParameter("boardtype"));
            Department d = new Department();
            d.setDeptName(request.getParameter("department"));
            d.setBuilding(request.getParameter("building"));
            v.setDepartment(d);
            out.println("asd");
            for (String s : request.getParameterMap().keySet()) {
                out.println(s + " " + request.getParameter(s) + "<br>");
            }
            DBInsertDeleteHandler dbh = new DBInsertDeleteHandler();
            dbh.insertHall(v);
            out.println("Done");
            response.sendRedirect("/uomrms/add_new_resource.jsp?success");

        } catch (Exception c) {
            c.printStackTrace();
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(add_hall.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(add_hall.class.getName()).log(Level.SEVERE, null, ex);
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
