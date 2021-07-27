package by.Matveev.filters;

import by.Matveev.service.input.Input;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(servletNames = "CalculationServlet")
public class TestDataFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        boolean flag = true;
        String i = req.getParameter("num1");
        if (!Input.getDouble(i)){
            res.getWriter().println(Input.getMessage("You incorrectly entered first number, need to enter the whole number"));
            flag = false;
        }
        String i1 = req.getParameter("num2");
        if (!Input.getDouble(i1)){
            res.getWriter().println(Input.getMessage("You incorrectly entered second number, need to enter the whole number"));
            flag = false;
        }
        String operation = req.getParameter("operation");
        if(!Input.checkTypeOfCalculation(operation)){
            res.getWriter().println(Input.getMessage("You incorrectly entered, functions. Try again please"));
            flag = false;
        }
        if(!Input.divZero(Integer.parseInt(i1), operation)){
            res.getWriter().println(Input.getMessage("Division by zero is prohibited"));
            flag = false;
        }
        if(flag){
            chain.doFilter(req, res);
        }
    }
}
