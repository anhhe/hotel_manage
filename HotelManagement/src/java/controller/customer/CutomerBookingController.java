/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.customer;

import dal.BookingDBContext;
import dal.CustomerDBContext;
import dal.OrderDBContext;
import dal.PaymentDBContext;
import dal.ProductDBContext;
import dal.RoomDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Account;
import model.Booking;
import model.Customer;
import model.Order;
import model.Payment;
import model.Product;
import model.Room;

/**
 *
 * @author Duc Anh
 */
public class CutomerBookingController extends HttpServlet {

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
            out.println("<title>Servlet CutomerBookingController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CutomerBookingController at " + request.getContextPath() + "</h1>");
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
        int roomID = Integer.parseInt(request.getParameter("roomID"));
        Room room = new RoomDBContext().getOne(roomID);

        Account account = (Account) request.getSession().getAttribute("account");
        Customer c = new CustomerDBContext().getOneByAccountID(account);

        ArrayList<Product> list_p = new ProductDBContext().getAll();

        request.setAttribute("list_p", list_p);
        request.setAttribute("c", c);
        request.setAttribute("room", room);
        request.getRequestDispatcher("../view/customer/customer_booking.jsp").forward(request, response);
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
        double amount = 0;
        int orderID = 0;
        int customerID = Integer.parseInt(request.getParameter("customerID"));
        int roomID = Integer.parseInt(request.getParameter("roomID"));
        Date checkIn = Date.valueOf(request.getParameter("checkIn"));
        Date checkOut = Date.valueOf(request.getParameter("checkOut"));
        String[] raw_product = request.getParameterValues("product");

        Customer customer = new CustomerDBContext().getOne(customerID);
        Room room = new RoomDBContext().getOne(roomID);

        Booking booking = new Booking(customer, room, checkIn, checkOut, true);
        int bookingID = new BookingDBContext().insert(booking);
        Booking b = new BookingDBContext().getOne(bookingID);
        amount = room.getRoomType().getPrice();

        long millis = System.currentTimeMillis();
        Date createDate = new Date(millis);
        
        if (raw_product != null) {
            for (String r_product : raw_product) {
                int productID = Integer.parseInt(r_product);
                Product product = new ProductDBContext().getOne(productID);

                String raw_quantity_product = request.getParameter("quantity_product" + productID);

                if (!raw_quantity_product.equals("") && !raw_quantity_product.equals("0")) {
                    int quantity_product = Integer.parseInt(raw_quantity_product);

                    Order order = new Order(product, b, createDate, quantity_product, product.getCost());
                    amount += product.getCost() * quantity_product;
                    orderID = new OrderDBContext().insert(order);
                }
            }

        }

        Payment payment = new Payment(b, amount, createDate, "", true);
        new PaymentDBContext().insert(payment);
        new RoomDBContext().updateStatus(roomID);
        response.sendRedirect("../customer/thanks");
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
