package by.Matveev.servlets.address;

import by.Matveev.service.ServiceFacade;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addresses")
public class AddressesServlet extends HttpServlet {
    private final ServiceFacade serviceFacade = new ServiceFacade();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("addressesList", serviceFacade.getAddresses());
        req.getServletContext().getRequestDispatcher("/address.jsp").forward(req, resp);
    }
}
