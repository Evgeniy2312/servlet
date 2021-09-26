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

@WebServlet(name = "UpdateTelephoneServlet",urlPatterns = "/updateTelephone")
public class UpdateTelephoneServlet extends HttpServlet {
    private final ServiceFacade serviceFacade = new ServiceFacade();
    private final long number = 000000;
    private long idUser = 0;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        idUser = Long.parseLong(req.getParameter("id"));
        req.getServletContext().getRequestDispatcher("/updateTelephone.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long num = Long.parseLong(req.getParameter("number"));
        if (serviceFacade.updateTelephone(new Telephone(idUser, number, (User)req.getSession().getAttribute("user")), num)){
            req.setAttribute("message", Input.getMessage("It's telephone successfully changed!!!"));
        }else req.setAttribute("message", Input.getMessage("Error in update of telephone. Try again!!!"));
        req.getServletContext().getRequestDispatcher("/updateTelephone.jsp").forward(req, resp);
    }
}
