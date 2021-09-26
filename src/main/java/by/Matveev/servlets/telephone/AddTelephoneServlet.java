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

@WebServlet( name = "AddTelephoneServlet",urlPatterns = "/addTelephone")
public class AddTelephoneServlet extends HttpServlet {
    private final ServiceFacade serviceFacade = new ServiceFacade();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/addTelephone.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long number = Long.parseLong(req.getParameter("number"));
        if(serviceFacade.addTelephone(new Telephone(number, (User)req.getSession().getAttribute("user")))){
            req.setAttribute("message", Input.getMessage("It's number successfully added!!!"));
        }else req.setAttribute("message", Input.getMessage("Error in adding of the telephone. Try again!!!"));
        req.getServletContext().getRequestDispatcher("/addTelephone.jsp").forward(req, resp);
    }
}
