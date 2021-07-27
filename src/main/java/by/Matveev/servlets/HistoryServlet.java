package by.Matveev.servlets;

import by.Matveev.dao.RememberingInformation;

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
        RememberingInformation rememberingInformation = new RememberingInformation();
        if(req.getParameter("login") != null)
            resp.getWriter().println(rememberingInformation.getOperationByLogin(req.getParameter("login")));
        else if (req.getParameter("name") != null)
            resp.getWriter().println(rememberingInformation.getOperationByNameOfFunctions(req.getParameter("name")));
        else resp.getWriter().println(rememberingInformation.getOperations());
    }
}
