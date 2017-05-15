package com.epam.HotelReleaze.dao;

import com.epam.HotelReleaze.models.User;
import org.hibernate.Query;
import org.hibernate.Session;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Antoha12018 on 13.05.2017.
 */
public class UserDaoImpl  implements UserDao{

    private Session session;

    public UserDaoImpl(){
        session = HibernateUtil.getSessionFactory().openSession();
    }
    @Override
    public void addUser(User user) throws Exception {
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
    }

    @Override
    public void updateUser(User user) throws Exception {
        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();
    }

    @Override
    public User getUserById(int id) throws Exception {
        User user = null;
        user = (User) session.load(User.class,id);
        return user;
    }

    @Override
    public Collection<User> getAllUsers() throws Exception {
        List<User> users = new ArrayList<User>();
        users = session.createCriteria(User.class).list();
        return users;
    }

    @Override
    public void deleteUser(User user) throws Exception {
        session.beginTransaction();
        session.delete(user);
        session.getTransaction().commit();

    }

    public User getUser(String name) {
        User result = null;
        Query query = session.createQuery("FROM User WHERE username='"+name+"'");
        return (User) query.uniqueResult();
    }
}
