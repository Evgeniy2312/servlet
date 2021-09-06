package by.Matveev.servlets;

import by.Matveev.dao.RememberingInformationDao;
import by.Matveev.entity.Operation;
import by.Matveev.entity.User;
import by.Matveev.dao.ListOperations;
import by.Matveev.service.ServiceFacade;
import by.Matveev.service.mathoperations.MapOperations;
import by.Matveev.service.utils.Input;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet( name = "CalculationServlet", urlPatterns = "/calc")
public class CalculationServlet extends HttpServlet {
    private final ServiceFacade serviceFacade = new ServiceFacade();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/calculation.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] numsStr= req.getParameterValues("numbers");
        double[] nums = Input.parseToDouble(numsStr);
        String typeOperation = req.getParameter("type");
        Operation operation = new Operation(nums[0], nums[1], typeOperation, (User) req.getSession().getAttribute("user"));
        double result = serviceFacade.calculate(operation);
        req.setAttribute("result", result);
        req.getServletContext().getRequestDispatcher("/calculation.jsp").forward(req, resp);
    }
}
