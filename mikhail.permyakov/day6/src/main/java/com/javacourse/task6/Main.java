package com.javacourse.task6;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
//        System.out.println("HW");
        String command = args[0];
        GuestBookController controller = new GuestBookController(null);
        switch(command){
            case "add":
                String message = args[1];
                controller.addMessage(message);
                break;
            case "list":
                List<Post> posts = controller.allMessages();
                for(Post post: posts){
                    System.out.printf("id=%s\tdate=%s\tmessage=%s\n",
                            post.getId(), post.getDate(), post.getMessage());
                }
                break;
            default:
                throw new RuntimeException("Unexpected command " + command);

        }
    }
}
