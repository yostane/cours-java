package com.cours.jee.servlet;

import java.io.IOException;

import com.cours.jee.model.CalculatorResult;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/calculate")
public class CalculatorServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nb1 = req.getParameter("nb1");
        String nb2 = req.getParameter("nb2");
        if (nb1 != null && nb2 != null) {
            int x = Integer.parseInt(nb1);
            int y = Integer.parseInt(nb2);
            CalculatorResult calculatorResult = new CalculatorResult(x + y, x - y);
            req.setAttribute("calculatorResult", calculatorResult);
        }
        req.getRequestDispatcher("/WEB-INF/calculator-result.jsp").forward(req, resp);
    }
}
