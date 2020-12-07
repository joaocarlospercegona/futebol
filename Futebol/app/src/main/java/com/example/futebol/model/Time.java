package com.example.futebol.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Time implements Parcelable {
    private int image;
    private String name;
    private String city;
    private String state;
    private ArrayList<String> achievements;

    public Time(int image, String name, String city, String state, ArrayList<String> achievements) {
        this.image = image;
        this.name = name;
        this.city = city;
        this.state = state;
        this.achievements = achievements;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(image);
        parcel.writeString(name);
        parcel.writeString(city);
        parcel.writeString(state);
        parcel.writeList(achievements);
    }

    private Time(Parcel in) {
        image = in.readInt();
        name = in.readString();
        city = in.readString();
        state = in.readString();
        achievements = in.readArrayList(null);
    }

    public static Creator<Time> CREATOR = new Creator<Time>() {

        @Override
        public Time createFromParcel(Parcel source) {
            return new Time(source);
        }

        @Override
        public Time[] newArray(int size) {
            return new Time[size];
        }

    };

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public ArrayList<String> getAchievements() {
        return achievements;
    }

    public void setAchievements(ArrayList<String> achievements) {
        this.achievements = achievements;
    }
}
