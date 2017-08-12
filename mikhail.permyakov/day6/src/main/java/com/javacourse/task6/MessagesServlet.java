package com.javacourse.task6;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "Messages servlet", urlPatterns = "/messages")
public class MessagesServlet extends HttpServlet{
    @Resource(name = "jdbc/testDS")
    private DataSource ds;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            GuestBookController guestBookController = new GuestBookController(ds);
            guestBookController.allMessages();
            List<Post> messages = guestBookController.allMessages();
           // resp.getOutputStream().println("Hello");
            req.setAttribute("message", messages);
            req.getRequestDispatcher("/WEB-INF/messages.jsp").forward(req, resp);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}
