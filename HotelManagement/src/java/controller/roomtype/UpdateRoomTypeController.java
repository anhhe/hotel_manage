/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.roomtype;

import dal.RoomTypeDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.RoomType;

/**
 *
 * @author Duc Anh
 */
public class UpdateRoomTypeController extends HttpServlet {

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
            out.println("<title>Servlet UpdateRoomTypeController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateRoomTypeController at " + request.getContextPath() + "</h1>");
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
        int roomtypeID = Integer.parseInt(request.getParameter("roomtypeID"));
        RoomType rt = new RoomType();
        rt.setID(roomtypeID);
        rt = new RoomTypeDBContext().getOne(rt);
        
        request.setAttribute("rt", rt);
        request.getRequestDispatcher("../view/roomtype/update.jsp").forward(request, response);
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
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        int roomtypeID = Integer.parseInt(request.getParameter("roomtypeID"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        int people = Integer.parseInt(request.getParameter("people"));
        String description2 = request.getParameter("description2");
        String description = request.getParameter("description");
        
        if(description == ""){
            description += description2;
        }
        
        RoomType rt = new RoomType(roomtypeID, name, price, people, description);
        new RoomTypeDBContext().update(rt);
        response.sendRedirect("../roomtype/list");
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
