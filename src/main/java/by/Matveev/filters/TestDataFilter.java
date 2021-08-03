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
        if(req.getMethod().equals("GET")){
            chain.doFilter(req, res);
        }
        if(req.getMethod().equals("POST")) {
            boolean flag = true;
            Double i1 = Double.parseDouble(req.getParameter("num2"));
            String operation = req.getParameter("operation");
            if (!Input.checkTypeOfCalculation(operation)) {
                req.setAttribute("incorrect", Input.getMessage("You incorrectly entered, functions. Try again please"));
                flag = false;
            }
            if (!Input.divZero(i1, operation)) {
                req.setAttribute("incorrect", Input.getMessage("Division by zero is prohibited"));
                flag = false;
            }
            if (flag) {
                chain.doFilter(req, res);
            }
            req.getServletContext().getRequestDispatcher("/calculation.jsp").forward(req , res);
        }
    }
}
