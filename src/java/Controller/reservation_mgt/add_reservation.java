/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.reservation_mgt;

import data.DBNotificationHandler;
import data.DBPrivilegeUserHandler;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.foundation.AuthorizedPerson;
import model.foundation.Notification;
import model.foundation.Person;
import model.foundation.Reservation;
import model.logic.ReservationHandler;

/**
 *
 * @author RAVIDU-PC
 */
public class add_reservation extends HttpServlet {

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
            Reservation reserve = new Reservation();
            reserve.setCapacity(Integer.parseInt(request.getParameter("capacity")));
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date start = format.parse(request.getParameter("from_date") + request.getParameter("from_time"));
            reserve.setStartTime(start);
            Date end = format.parse(request.getParameter("to_date") + request.getParameter("to_time"));
            reserve.setEndTime(end);
            reserve.setResourceId(request.getParameter("resourceid"));
            String username=request.getParameter("admin");//(String)request.getSession().getAttribute("username");
            AuthorizedPerson person=new AuthorizedPerson();
            person.setUsername(username);
            Person p=new DBPrivilegeUserHandler().getLoggedPerson(person);
            reserve.setPersonId(p.getId());
            reserve.setApproval(0);
            reserve.setPurpose(request.getParameter("purpose"));
            ReservationHandler handler = new ReservationHandler();
            int id=handler.addReservation(reserve);
            
            // Adding the notification
            Notification no=new Notification(request.getParameter("notification"),p,id);
            DBNotificationHandler dbnh = new DBNotificationHandler();
            dbnh.addNotificationForMgr(no);
            
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
        try {
            processRequest(request, response);
        } catch (Exception e) {
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
        } catch (Exception e) {
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
