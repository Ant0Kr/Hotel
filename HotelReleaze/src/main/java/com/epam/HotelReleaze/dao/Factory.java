package com.epam.HotelReleaze.dao;

/**
 * Created by Antoha12018 on 13.05.2017.
 */
public class Factory {
    private static Factory instance = null;
    private static UserDao userDAO = null;
    private static RoomDao roomDAO = null;


    public static synchronized Factory getInstance() {
        if (instance == null) {
            instance = new Factory();
        }
        return instance;
    }

    public UserDao getUserDAO() {
        if (userDAO == null) {
            userDAO = new UserDaoImpl();
        }
        return userDAO;
    }

    public RoomDao getRoomDAO() {
        if (roomDAO == null) {
            roomDAO = new RoomDaoImpl();
        }
        return roomDAO;
    }

}
