package org.eclipse.jakarta.hello.Servlet;

import java.io.IOException;
import java.util.Random;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/rvalue")
public class RandomServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var r = new Random();
        req.setAttribute("randomValue", r.nextInt());
        // String value = req.getParameter("userValue");
        // int userValue = Integer.valueOf(value);
        // boolean hasWon = userValue
        this.getServletContext().getRequestDispatcher("/WEB-INF/randval.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String value1 = req.getParameter("value1");
        String value2 = req.getParameter("value2");
        Integer sum = Integer.valueOf(value1) + Integer.valueOf(value2);
        req.setAttribute("sum", sum);
        this.getServletContext().getRequestDispatcher("/WEB-INF/sum.jsp").forward(req, resp);
    }

}
