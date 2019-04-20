package com.twu.biblioteca;

public class Movie {
    private String title;
    private boolean isCheckedOut;

    public Movie(String title) {
        this.title = title;
        this.isCheckedOut = false;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCheckedOut() {
        return this.isCheckedOut;
    }
}