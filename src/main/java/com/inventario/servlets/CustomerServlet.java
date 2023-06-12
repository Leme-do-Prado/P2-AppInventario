package com.inventario.servlets;

import com.inventario.dao.CustomerDAO;
import com.inventario.model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/customer")
public class CustomerServlet extends HttpServlet {
    private CustomerDAO customerDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        customerDAO = new CustomerDAO();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String customerId = req.getParameter("customerId");
        String customerName = req.getParameter("customerName");
        String city = req.getParameter("city");
        int grade = Integer.parseInt(req.getParameter("grade"));
        int salesmanId = Integer.parseInt(req.getParameter("salesmanId"));

        Customer customer = new Customer(customerId, customerName, city, grade, salesmanId);
        customerDAO.addCustomer(customer);
    }
}

