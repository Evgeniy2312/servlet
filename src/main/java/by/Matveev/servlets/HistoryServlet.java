package by.Matveev.servlets;

import by.Matveev.dao.ListOperations;
import by.Matveev.dao.RememberingInformationDao;
import by.Matveev.entity.User;
import by.Matveev.service.ServiceFacade;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/history")
public class HistoryServlet extends HttpServlet {
    private final ServiceFacade serviceFacade = new ServiceFacade();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("name") == null) {
//            req.setAttribute("list", serviceFacade.getOperationBySession((User) req.getSession().getAttribute("user")));
            req.getServletContext().getRequestDispatcher("/history.jsp").forward(req, resp);
        } else {
            doPost(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setAttribute("list", serviceFacade.getOperationByType((User) req.getSession().getAttribute("user"), req.getParameter("name")));
        req.getServletContext().getRequestDispatcher("/history.jsp").forward(req, resp);
    }
}
