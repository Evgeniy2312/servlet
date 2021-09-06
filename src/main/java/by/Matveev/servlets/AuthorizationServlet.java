package by.Matveev.servlets;

import by.Matveev.entity.User;
import by.Matveev.service.ServiceFacade;
import by.Matveev.service.utils.Input;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "authorization", urlPatterns = "/auth")
public class AuthorizationServlet extends HttpServlet {
    private final ServiceFacade serviceFacade = new ServiceFacade();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/authorization.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        User user = new User(login, password);
        Optional<User> optionalUser = serviceFacade.authorization(user);
        if (optionalUser.isPresent()) {
            req.getSession().setAttribute("user", optionalUser.get());
            req.setAttribute("message", Input.getMessage("Authorization has passed successfully!"));
        } else req.setAttribute("message", Input.getMessage("Invalid Log In!"));
        req.getServletContext().getRequestDispatcher("/authorization.jsp").forward(req, resp);
    }
}
