package com.example.retrofitexample;

public class DataModel {
    /**
     * This model class will be template for the data that we will going to parse
     */
    private int userId;
    private int id;
    private String title;
    private boolean completed;


    //Getters


    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCompleted() {
        return completed;
    }
}
