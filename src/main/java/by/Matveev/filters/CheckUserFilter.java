package by.Matveev.filters;

import by.Matveev.entity.User;
import by.Matveev.service.input.Input;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(servletNames = "CalculationServlet")
public class CheckUserFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        User user = (User) req.getSession().getAttribute("user");
        if(user == null || req.getSession() == null) res.getWriter().println(Input.getMessage("You haven't authorized yet."));
        else chain.doFilter(req, res);
    }
}
