package by.Matveev.servlets;

import by.Matveev.dao.ListUser;
import by.Matveev.dao.UserDao;
import by.Matveev.entity.User;
import by.Matveev.service.input.Input;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "registration", urlPatterns = "/reg")
public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        UserDao userDao = new ListUser();
        if (userDao.addUser(new User(login, password))) {
            resp.getWriter().println(Input.getMessage("Registration passed successfully"));
        } else resp.getWriter().println(Input.getMessage("This user has already existed"));
    }
}