package by.Matveev.filters;

import by.Matveev.service.utils.Input;

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
        if (req.getMethod().equals("GET")) {
            chain.doFilter(req, res);
        }
        if (req.getMethod().equals("POST")) {
            String[] strings = req.getParameterValues("numbers");
            Double i1 = Double.parseDouble(strings[1]);
            String operation = req.getParameter("type");
            if (Input.divZero(i1, operation)) {
                req.setAttribute("message", Input.getMessage("Division by zero is prohibited"));
                req.getServletContext().getRequestDispatcher("/calculation.jsp").forward(req, res);
            } else chain.doFilter(req, res);
        }
    }
}