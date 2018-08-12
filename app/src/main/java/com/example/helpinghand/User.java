package com.example.helpinghand;

public class User {
    private String ID;
    private String LOGIN;
    private String PASSWORD;
    private String NAME;
    private String FORENAME;
    private int POINTS;

    public User(String ID, String LOGIN, String PASSWORD, String NAME, String FORENAME, int POINTS){
        this.ID=ID;
        this.LOGIN=LOGIN;
        this.PASSWORD=PASSWORD;
        this.NAME= NAME;
        this.FORENAME= FORENAME;
        this.POINTS=POINTS;
    }

    public String getNAME() {
        return NAME;
    }
}
