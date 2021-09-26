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

@WebServlet(name = "UpdateAddressServlet",urlPatterns = "/updateAddress")
public class UpdateAddressServlet extends HttpServlet {
    private final ServiceFacade serviceFacade = new ServiceFacade();
    private long idUser = 0;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        idUser = Long.parseLong(req.getParameter("id"));
        req.getServletContext().getRequestDispatcher("/updateAddress.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String street = req.getParameter("street");
       int num = Integer.parseInt(req.getParameter("number"));
       if(serviceFacade.updateAddress(new Address(idUser, (User) req.getSession().getAttribute("user")), num, street)){
           req.setAttribute("message", Input.getMessage("It's address successfully changed"));
       }else req.setAttribute("message", Input.getMessage("Error in update of the address. Try again!!!"));
       req.getServletContext().getRequestDispatcher("/updateAddress.jsp").forward(req, resp);
    }
}
