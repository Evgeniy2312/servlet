package by.Mayveev;

import by.Mayveev.service.ControllerCalculation;
import by.Mayveev.service.ControllerCalculationImpl;
import by.Mayveev.dao.RememberingInformation;
import by.Mayveev.service.input.Input;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/test")
public class Calculation extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String i = req.getParameter("num1");
        if (!Input.getInt(i)){
            resp.getWriter().println("You incorrectly entered, need to enter the whole number");
            return;
        }
        String i1 = req.getParameter("num2");
        if (!Input.getInt(i1)){
            resp.getWriter().println("You incorrectly entered, need to enter the whole number");
            return;
        }
        String operation = req.getParameter("operation");
        if(!Input.checkTypeOfCalculation(operation)){
            resp.getWriter().println("You incorrectly entered, functions. Try again please");
            return;
        }
        if(!Input.divZero(Integer.valueOf(i1), operation)){
            resp.getWriter().println("Division by zero is prohibited");
        }
        ControllerCalculation daoCalculation = new ControllerCalculationImpl();
        String result = daoCalculation.getResult(Integer.valueOf(i), Integer.valueOf(i1), operation);
        resp.getWriter().println(result);
        RememberingInformation rememberingInformation = new RememberingInformation();
        rememberingInformation.getResults(Integer.valueOf(i), Integer.valueOf(i1), operation, result);
    }
}
