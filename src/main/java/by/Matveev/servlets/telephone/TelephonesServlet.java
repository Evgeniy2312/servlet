package by.Matveev.servlets.telephone;

import by.Matveev.service.ServiceFacade;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/telephones")
public class TelephonesServlet extends HttpServlet {
    private final ServiceFacade serviceFacade = new ServiceFacade();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("telephoneList", serviceFacade.getTelephones());
        req.getServletContext().getRequestDispatcher("/telephone.jsp").forward(req,resp);
    }
}
