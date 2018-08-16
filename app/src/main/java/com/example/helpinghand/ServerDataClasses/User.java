package com.example.helpinghand.ServerDataClasses;

public class User {
    private String ID;
    private String LOGIN;
    private String PASSWORD;
    private String NAME;
    private String FORENAME;
    private int POINTS;

    public String getID() {
        return ID;
    }

    public String getLOGIN() {
        return LOGIN;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public String getFORENAME() {
        return FORENAME;
    }

    public int getPOINTS() {
        return POINTS;
    }

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

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setLOGIN(String LOGIN) {
        this.LOGIN = LOGIN;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public void setFORENAME(String FORENAME) {
        this.FORENAME = FORENAME;
    }

    public void setPOINTS(int POINTS) {
        this.POINTS = POINTS;
    }
}
