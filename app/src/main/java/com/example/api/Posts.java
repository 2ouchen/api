package com.example.api;

public class Posts {

        private String title;
        private String body;

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public Posts(String title, String body) {
        this.title = title;
        this.body = body;
    }
}
