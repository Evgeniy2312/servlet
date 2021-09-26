package by.Matveev.filters;

import by.Matveev.entity.User;
import by.Matveev.service.RegistrationService;
import by.Matveev.service.utils.Input;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(servletNames = {"CalculationServlet", "HistoryServlet", "AddAddressServlet", "UpdateAddressServlet", "AddTelephoneServlet", "UpdateTelephoneServlet"})
public class CheckUserFilter extends HttpFilter {
    private static final Logger logger = LoggerFactory.getLogger(CheckUserFilter.class);

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        if(req.getMethod().equals("GET")){
            chain.doFilter(req, res);
        }
        if(req.getMethod().equals("POST")) {
            User user = (User) req.getSession().getAttribute("user");
            if (user == null || req.getSession() == null){
                logger.warn("User try to enter the calculate without authorization");
                req.setAttribute("message", Input.getMessage("You haven't authorized yet"));
                req.getServletContext().getRequestDispatcher("/calculation.jsp").forward(req, res);
            } else chain.doFilter(req, res);
        }
    }
}
