package com.inventario.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inventario.dao.OrdersDAO;
import com.inventario.model.Orders;

@WebServlet("/orders")
public class OrdersServlet extends HttpServlet {
    private OrdersDAO ordersDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        ordersDAO = new OrdersDAO();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int ordNo = Integer.parseInt(req.getParameter("ordNo"));
        int purchAmt = Integer.parseInt(req.getParameter("purchAmt"));
        
        String ordDateStr = req.getParameter("ordDate");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date ordDate = null;

        try {
            ordDate = dateFormat.parse(ordDateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }        
        
        int customerId = Integer.parseInt(req.getParameter("customerId"));
        int salesmanId = Integer.parseInt(req.getParameter("salesmanId"));

        Orders orders = new Orders(ordNo, purchAmt, ordDate, customerId, salesmanId);
        ordersDAO.addOrder(orders);
    }
}
