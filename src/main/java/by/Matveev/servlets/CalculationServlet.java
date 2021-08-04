package by.Matveev.servlets;

import by.Matveev.entity.Operation;
import by.Matveev.entity.User;
import by.Matveev.dao.ListOperations;
import by.Matveev.service.MapOperations;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet( name = "CalculationServlet", urlPatterns = "/test")
public class CalculationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/calculation.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Double i = Double.parseDouble(req.getParameter("num1"));
        Double i1 =Double.parseDouble(req.getParameter("num2"));
        String operation = req.getParameter("operation");
        Operation function = MapOperations.OPERATIONS_MAP.get(operation).getResult(i, i1);
        function.setUser((User) req.getSession().getAttribute("user"));
        req.setAttribute("operation", function.getResult());
        new ListOperations().getOperations().add(function);
        req.getServletContext().getRequestDispatcher("/ccalculation.jsp").forward(req, resp);
    }
}
