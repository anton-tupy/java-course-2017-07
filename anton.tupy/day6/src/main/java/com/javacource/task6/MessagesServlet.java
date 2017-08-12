package com.javacource.task6;

import javax.sql.DataSource;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by IT-Academy on 12.08.2017.
 */
@WebServlet(name = "MessagesServlet", urlPatterns = "/messages")
public class MessagesServlet extends HttpServlet {

    @Resource(name = "jdbc/testDS")
    private DataSource ds;

    @Override
    protected void doGet(
            HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {

            GuestBookController guestBookController = new GuestBookController(ds);
            List<Post> messages = guestBookController.allMessages();

            req.setAttribute("messages", messages);

            req.getRequestDispatcher("/WEB-INF/messages.jsp").forward(req, resp);

        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

}
