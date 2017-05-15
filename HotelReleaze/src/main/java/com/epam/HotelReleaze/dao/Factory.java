package com.epam.HotelReleaze.dao;

/**
 * Created by Antoha12018 on 13.05.2017.
 */
public class Factory {
    private static Factory instance = null;
    private static UserDao userDAO = null;


    public static synchronized Factory getInstance() {
        if (instance == null) {
            instance = new Factory();
        }
        return instance;
    }

    public UserDao getItemDAO() {
        if (userDAO == null) {
            userDAO = new UserDaoImpl();
        }
        return userDAO;
    }

}
