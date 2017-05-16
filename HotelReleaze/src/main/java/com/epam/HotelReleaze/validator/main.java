package com.epam.HotelReleaze.validator;

import com.epam.HotelReleaze.dao.Factory;
import com.epam.HotelReleaze.models.User;
import org.hibernate.Session;

/**
 * Created by Antoha12018 on 13.05.2017.
 */
public class main {


    public static void main(String [] args) throws Exception {
        Session session = null;
        User user = Factory.getInstance().getUserDAO().getUserById(1);
        System.out.println(user.getUsername());


        if (session != null && session.isOpen()) {
            session.close();
        }
    }
}
