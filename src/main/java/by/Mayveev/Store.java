package by.Mayveev;

import by.Mayveev.dao.RememberingInformation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/log")
public class Store extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RememberingInformation rememberingInformation = new RememberingInformation();
        resp.getWriter().println(rememberingInformation.getStore());
    }
}
