package com.javacource.task6;

import javax.sql.DataSource;
import java.sql.*;
import java.util.*;

/**
 * Created by IT-Academy on 10.08.2017.
 */
public class GuestBookController {

    private DataSource dataSource;

    public GuestBookController(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void addMessage(String message) throws SQLException {
        try (Connection connection = connect()) {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO POSTS(POSTMESSAGE, POSTDATE) VALUES(?, ?)");
            statement.setString(1, message);
            java.sql.Date date = new java.sql.Date(new java.util.Date().getTime());
            statement.setDate(2, date);

            statement.executeUpdate();
        }
    }

    public List<Post> allMessages() throws SQLException {
        try (Connection connection = connect()) {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT ID, POSTMESSAGE, POSTDATE FROM POSTS");

            ResultSet resultSet = statement.executeQuery();

            ArrayList<Post> posts = new ArrayList<>();
            while(resultSet.next()) {
                Post post = new Post(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getDate(3));
                posts.add(post);
            }
            return posts;
        }
    }

    private Connection connect() throws SQLException {
        return dataSource.getConnection();
    }
}
