package com.example.servlet;

import com.example.User;
import com.example.Warehouse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@WebServlet("/users")
public class GetUsersServlet extends HttpServlet {
    //write your code here!
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Set<User> users = Warehouse.getInstance().getUsers();
        req.setAttribute("users", users);

        try {
            req.getRequestDispatcher("/users.jsp").forward(req, resp);
        } catch (ServletException | IOException e) {
            // handle the exception here
            e.printStackTrace();
            // or log the exception and return a user-friendly error message to the user
            resp.getWriter().println("An error occurred while processing your request. Please try again later.");
        }
    }
}
