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

@WebServlet(name = "authorization", urlPatterns = "/auth")
public class AuthorizationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        UserDao userDao = new ListUser();
        User user = new User(login,password);
        if(userDao.getUser().contains(user)) {
            req.getSession().setAttribute("user", user);
            resp.sendRedirect("/test");
        }else {
            req.setAttribute("incorrectData", Input.getMessage("This user hasn't existed yet.Need to register"));
            req.getServletContext().getRequestDispatcher("/registration.jsp").forward(req, resp);
        }
    }
}
