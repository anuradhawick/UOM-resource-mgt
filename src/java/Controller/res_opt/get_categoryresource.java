/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.res_opt;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.foundation.Hall;
import model.foundation.Lab;
import model.foundation.Resource;
import model.logic.ResourceHandler;

/**
 *
 * @author RAVIDU-PC
 */
public class get_categoryresource extends HttpServlet {

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
            int offset = Integer.parseInt(request.getParameter("offset"));
            int limit = Integer.parseInt(request.getParameter("limit"));
            ResourceHandler handle = new ResourceHandler();
            ArrayList<Resource> resourcelist = handle.getCategoryWiseResources(category, offset, limit);
            if (resourcelist != null) {
                if (resourcelist.get(0) instanceof Hall) {
                    ArrayList<Hall> halllist = new ArrayList<>();
                    for (Resource r : resourcelist) {
                        Hall h = (Hall) r;
                        halllist.add(h);
                    }
                    String json = new Gson().toJson(halllist);
                    out.print(json);
                } else if (resourcelist.get(0) instanceof Lab) {
                    ArrayList<Lab> lablist = new ArrayList<>();
                    for (Resource r : resourcelist) {
                        Lab l = (Lab) r;
                        lablist.add(l);
                    }
                    String json = new Gson().toJson(lablist);
                    out.print(json);
                } else {
                    String json = new Gson().toJson(resourcelist);
                    out.print(json);
                }
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
