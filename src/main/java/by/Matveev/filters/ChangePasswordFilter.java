package by.Matveev.filters;

import by.Matveev.entity.User;
import by.Matveev.service.ChangePasswordService;
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

@WebFilter(servletNames = "ChangePasswordServlet")
public class ChangePasswordFilter extends HttpFilter {
    private static final Logger logger = LoggerFactory.getLogger(ChangePasswordFilter.class);

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        if (req.getMethod().equals("GET")) {
            chain.doFilter(req, res);
        }
        if (req.getMethod().equals("POST")) {
            if (req.getSession().getAttribute("user") != null) {
                String oldPassword = req.getParameter("old password");
                String password = req.getParameter("password");
                User user = (User) req.getSession().getAttribute("user");
                if (user.getPassword().equals(oldPassword)) {
                    if (!user.getPassword().equals(password)) {
                        chain.doFilter(req, res);
                    } else
                        req.setAttribute("message", Input.getMessage("You cannot change your password on an existing!"));
                } else {
                    logger.warn("User with name {} try to changed his password", user.getName());
                    req.setAttribute("message", Input.getMessage("Incorrectly entered the old password"));
                }
            } else req.setAttribute("message", Input.getMessage("You haven't authorized yet!"));
            req.getServletContext().getRequestDispatcher("/change.jsp").forward(req, res);
        }
    }
}