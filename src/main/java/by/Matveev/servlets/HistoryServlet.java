package by.Matveev.servlets;

import by.Matveev.dao.ListOperations;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/history")
public class HistoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/history.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ListOperations rememberingInformation = new ListOperations();
        if (req.getParameter("login") != null)
            req.setAttribute("list", rememberingInformation.getOperationByLogin(req.getParameter("login")));
        else if (req.getParameter("name") != null)
            req.setAttribute("list", rememberingInformation.getOperationByNameOfFunctions(req.getParameter("name")));
        else req.setAttribute("list", rememberingInformation.getOperations());
        req.getServletContext().getRequestDispatcher("/history.jsp").forward(req, resp);
    }
}
