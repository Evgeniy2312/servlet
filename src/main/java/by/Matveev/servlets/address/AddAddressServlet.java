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

@WebServlet(name = "AddAddressServlet",urlPatterns = "/addAddress")
public class AddAddressServlet extends HttpServlet {
    private final ServiceFacade serviceFacade = new ServiceFacade();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/addAddress.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String street = req.getParameter("street");
        int num =Integer.parseInt(req.getParameter("number"));
        if (serviceFacade.addAddress(new Address( num, street, (User)req.getSession().getAttribute("user")))){
            req.setAttribute("message", Input.getMessage("Address successfully added"));
        }else req.setAttribute("message", Input.getMessage("Error in adding of the address. Try again!!!"));
        req.getServletContext().getRequestDispatcher("/addAddress.jsp").forward(req, resp);
    }
}
