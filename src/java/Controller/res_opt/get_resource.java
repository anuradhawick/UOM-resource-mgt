/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.res_opt;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.foundation.Hall;
import model.foundation.Lab;
import model.logic.ResourceHandler;

/**
 *
 * @author RAVIDU-PC
 */
public class get_resource extends HttpServlet {

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
            String category = request.getParameter("category");
            int id = Integer.parseInt(request.getParameter("resourceid"));
            ResourceHandler handler = new ResourceHandler();
            if (handler.getResource(category, id) instanceof Hall) {
                Hall h = (Hall) handler.getResource(category, id);
                String json = new Gson().toJson(h.getResourceid() + h.getResourceName() + h.getCapacityAmount() + h.getDescription() + h.getCategory() + h.isAirConditioned() + h.isProjectorAvailable() + h.getBoardType() + h.getDepartment().getDeptName() + h.getDepartment().getBuilding());
            } else if (handler.getResource(category, id) instanceof Lab) {
                Lab h = (Lab) handler.getResource(category, id);
                String json = new Gson().toJson(h.getResourceid() + h.getResourceName() + h.getCapacityAmount() + h.getDescription() + h.getCategory() + h.isAirConditioned() + h.getDepartment().getDeptName() + h.getDepartment().getBuilding());
            } else {
                String json = new Gson().toJson(handler.getResource(category, id) + "");
                out.print(json);
            }

        } catch (Exception e) {
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
