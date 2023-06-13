package com.inventario.servlets;

import com.inventario.dao.SalesmanDAO;
import com.inventario.model.Salesman;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/salesman")
public class SalesmanServlet extends HttpServlet {
    private SalesmanDAO salesmanDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        salesmanDAO = new SalesmanDAO();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int salesmanId = Integer.parseInt(req.getParameter("salesmanId"));
        String name = req.getParameter("name");
        double commission = Double.parseDouble(req.getParameter("commission"));
        String city = req.getParameter("city");

        Salesman salesman = new Salesman(salesmanId, name, city, commission);
        salesmanDAO.addSalesman(salesman);
    }
}
