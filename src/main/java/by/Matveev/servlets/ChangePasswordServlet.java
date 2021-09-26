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

@WebServlet( name = "ChangePasswordServlet", urlPatterns = "/change")
public class ChangePasswordServlet extends HttpServlet {
    private final ServiceFacade serviceFacade = new ServiceFacade();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/change.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String password = req.getParameter("password");
        User user = (User) req.getSession().getAttribute("user");
        if(serviceFacade.changePassword(user, password)){
            req.setAttribute("message", "Your password successfully changed!");
        }else  req.setAttribute("message", "Error in the changing of password!");

        req.getServletContext().getRequestDispatcher("/change.jsp").forward(req, resp);
    }
}
