package com.javacource.task6;

import java.util.Date;

/**
 * Created by IT-Academy on 10.08.2017.
 */
public class Post {
    private Integer id;
    private String message;
    private Date date;

    public Post() {
    }

    public Post(Integer id, String message, Date date) {
        this.id = id;
        this.message = message;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
