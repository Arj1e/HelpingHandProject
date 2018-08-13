package com.example.helpinghand.ServerDataClasses;
public class Marker {
    private String rep_ID;
    private Double rep_LAT;
    private Double rep_LNG;
    private String ans_ID;
    private Double ans_LAT;
    private Double ans_LNG;
    private int status;

    public Marker(String rep_ID, Double rep_LAT, Double rep_LNG, String ans_ID, Double ans_LAT, Double ans_LNG, int status){
        this.rep_ID = rep_ID;
        this.rep_LAT = rep_LAT;
        this.rep_LNG = rep_LNG;
        this.ans_ID = ans_ID;
        this.ans_LAT = ans_LAT;
        this.ans_LNG = ans_LNG;
        this.status = status;
    }
}
