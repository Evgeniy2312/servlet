package by.Matveev.servlets.telephone;

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

@WebServlet("/deleteTelephone")
public class RemoveTelephoneServlet extends HttpServlet {
    private final ServiceFacade serviceFacade = new ServiceFacade();
    private final long number = 000000;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        if(serviceFacade.deleteTelephone(new Telephone(id, number, (User) req.getSession().getAttribute("user")))){
            req.setAttribute("message", Input.getMessage("It's number successfully deleted"));
        }else req.setAttribute("message", Input.getMessage("Error in delete of the telephone. Try again!!!"));
        req.getServletContext().getRequestDispatcher("/telephone.jsp").forward(req, resp);
    }
}
