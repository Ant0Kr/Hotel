package com.epam.HotelReleaze.models;


import javax.persistence.*;

/**
 * Created by Antoha12018 on 10.05.2017.
 */
@Entity
@Table(name="hotelrooms")
public class Room {


    //CHeckIN checkOUT
    @Id
    @Column(name = "numbersID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int roomID;

    @Column(name = "roomType")
    private int roomType;

    @Column(name = "state")
    private boolean state;

    @Column(name = "userID")
    private int userID;

    public int getRoomID() {
        return roomID;
    }

    public void setRoomId(int roomID) {
        this.roomID = roomID;
    }

    public int getRoomType(){
        return roomType;
    }

    public void setRoomType(int roomType){
        this.roomType = roomType;
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

    public String getStringRoomTypeRU(){
        switch (roomType){
            case 1: return "Односпальный номер";
            case 2: return "Двуспальный номер";
            case 3: return "Большой номер на 4 человека";
        }
        return "";
    }

    public String getStringRoomTypeEN(){
        switch (roomType){
            case 1: return "Room with one bed";
            case 2: return "Room with two beds";
            case 3: return "Room with four beds";
        }
        return "";
    }

    public String getStringStateRU(){
        if(state)
            return "Забронирован";
        else
            return "Свободен";
    }

    public String getStringStateEN(){
        if(state)
            return "Booked";
        else
            return "Free";
    }

}
