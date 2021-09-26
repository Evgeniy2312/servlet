package by.Matveev.servlets;

import by.Matveev.dao.ListUser;
import by.Matveev.dao.UserDao;
import by.Matveev.entity.Address;
import by.Matveev.entity.Telephone;
import by.Matveev.entity.User;
import by.Matveev.service.ServiceFacade;
import by.Matveev.service.utils.Input;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

    @WebServlet(name = "registration", urlPatterns = "/reg")
public class RegistrationServlet extends HttpServlet {
        private final ServiceFacade serviceFacade = new ServiceFacade();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        long number = Long.parseLong(req.getParameter("number"));
        int numberOfHome = Integer.parseInt(req.getParameter("home"));
        String street = req.getParameter("street");
        User user = new User(login, password, name);
        if (serviceFacade.registration(user)) {
            User userForInfo = serviceFacade.getByLogin(user.getLogin());
            serviceFacade.addTelephone(new Telephone(true, number, userForInfo));
            serviceFacade.addAddress(new Address(true, numberOfHome, street,userForInfo));
            req.setAttribute("message", Input.getMessage("Registration has passed successfully "));
        } else req.setAttribute("message", Input.getMessage("Invalid in registration"));
        req.getServletContext().getRequestDispatcher("/registration.jsp").forward(req, resp);
    }
}

