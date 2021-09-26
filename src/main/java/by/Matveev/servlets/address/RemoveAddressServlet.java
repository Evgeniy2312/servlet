package by.Matveev.servlets.address;

import by.Matveev.entity.Address;
import by.Matveev.entity.User;
import by.Matveev.service.ServiceFacade;
import by.Matveev.service.utils.Input;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteAddress")
public class RemoveAddressServlet extends HttpServlet {
    private final ServiceFacade serviceFacade = new ServiceFacade();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        if (serviceFacade.deleteAddress(new Address(id, (User) req.getSession().getAttribute("user")))) {
            req.setAttribute("message", Input.getMessage("It's password successfully deleted"));
        } else req.setAttribute("message", Input.getMessage("Error in delete of the address. Try again"));
        req.getServletContext().getRequestDispatcher("/address.jsp").forward(req, resp);
    }
}
