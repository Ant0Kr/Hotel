package com.epam.HotelReleaze.models;

/**
 * Created by Antoha12018 on 10.05.2017.
 */
public class Room {

    private int roomID;
    private boolean state;
    private int userID;

    public int getRoomID() {
        return roomID;
    }

    public void setId(int roomID) {
        this.roomID = roomID;
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }



}
