
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.reservation_mgt;

import com.google.gson.Gson;
import data.DBPrivilegeUserHandler;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.foundation.AuthorizedPerson;
import model.foundation.Person;
import model.foundation.Reservation;
import model.logic.ReservationHandler;

/**
 *
 * @author RAVIDU-PC
 */
public class get_userreservation extends HttpServlet {

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
            String username = (String) request.getSession().getAttribute("username");
            AuthorizedPerson person = new AuthorizedPerson();
            person.setUsername(username);
            Person p = new DBPrivilegeUserHandler().getLoggedPerson(person);
            
            String startdate = request.getParameter("from");
            String enddate = request.getParameter("to");
            String page = request.getParameter("page");
            SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
            Date d1 = fm.parse(startdate);
            Date d2 = fm.parse(enddate);
            ReservationHandler handle = new ReservationHandler();
            ArrayList<Reservation> list = handle.getUserresrvation(p.getId(), d1, d2);

            String json = new Gson().toJson(list);
            out.print(json);
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
