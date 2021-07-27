package by.Matveev.servlets;

import by.Matveev.entity.Operation;
import by.Matveev.entity.User;
import by.Matveev.service.ControllerCalculationImpl;
import by.Matveev.dao.RememberingInformation;
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
        String i = req.getParameter("num1");
        String i1 = req.getParameter("num2");
        String operation = req.getParameter("operation");
        Operation function = MapOperations.OPERATIONS_MAP.get(operation).getResult(Double.valueOf(i), Double.valueOf(i1));
        function.setUser((User) req.getSession().getAttribute("user"));
        resp.getWriter().println(function);
        new RememberingInformation().getOperations().add(function);
    }
}
