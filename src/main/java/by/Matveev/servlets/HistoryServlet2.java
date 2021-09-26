package by.Matveev.servlets;


import by.Matveev.entity.Operation;
import by.Matveev.entity.User;
import by.Matveev.service.Dependencies;
import by.Matveev.service.ServiceFacade;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet( name = "HistoryServlet", urlPatterns = "/history2")
public class HistoryServlet2 extends HttpServlet {
    private final ServiceFacade serviceFacade = new ServiceFacade();
    private int numValues = 5;
    private int currentPage = 1;
    private int numPages = 0;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("name") == null){
            if(req.getParameter("currentPage") != null){
                currentPage = Integer.parseInt(req.getParameter("currentPage"));
            }
            List<Operation> operations = serviceFacade.getOperationBySession(
                    (User)req.getSession().getAttribute("user"),
                    currentPage, numValues);
            numPages = Dependencies.historyService2.getSizeListForResp();
            req.setAttribute("currentList", operations);
            req.setAttribute("numPages", numPages);
            req.setAttribute("currentPage", currentPage);
            req.getServletContext().getRequestDispatcher("/history").forward(req, resp);
        }else doPost(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type = req.getParameter("name");
        if(req.getParameter("currentPage") != null){
            currentPage = Integer.parseInt(req.getParameter("currentPage"));
        }
        List<Operation> operations = serviceFacade.getOperationByType(currentPage,
                numValues,
                (User)req.getSession().getAttribute("user"),
                type);
        numPages = Dependencies.historyService2.getSizeListForResp();
        req.setAttribute("numPages", numPages);
        req.setAttribute("currentPage", currentPage);
        req.setAttribute("type", type);
        req.setAttribute("currentList", operations);
        req.getServletContext().getRequestDispatcher("/historyByType.jsp").forward(req, resp);
    }
}
