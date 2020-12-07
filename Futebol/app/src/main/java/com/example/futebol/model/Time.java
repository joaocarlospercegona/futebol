package com.example.futebol.model;

import java.util.ArrayList;

public class Time {
    private int img;
    private String name;
    private String owner;
    private ArrayList<String> conquistas;

    public Time() {

    }

    public Time(int img, String name, String owner, ArrayList<String> conquistas) {
        this.img = img;
        this.name = name;
        this.owner = owner;
        this.conquistas = conquistas;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public ArrayList<String> getConquistas() {
        return conquistas;
    }

    public void setConquistas(ArrayList<String> conquistas) {
        this.conquistas = conquistas;
    }
}
