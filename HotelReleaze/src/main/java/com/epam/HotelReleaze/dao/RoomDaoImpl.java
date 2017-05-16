package com.epam.HotelReleaze.dao;

import com.epam.HotelReleaze.models.Room;
import com.epam.HotelReleaze.models.User;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Antoha12018 on 15.05.2017.
 */
public class RoomDaoImpl implements RoomDao {

    private Session session;

    public RoomDaoImpl(){
        session = HibernateUtil.getSessionFactory().openSession();
    }

    @Override
    public void addRoom(Room room) throws Exception {
        session.beginTransaction();
        session.save(room);
        session.getTransaction().commit();
    }

    @Override
    public void updateRoom(Room room) throws Exception {
        session.beginTransaction();
        session.update(room);
        session.getTransaction().commit();
    }

    @Override
    public Room getRoomById(int id) throws Exception {
        Room room;
        room = (Room) session.load(Room.class,id);
        return room;
    }

    @Override
    public Collection<Room> getAllRooms() throws Exception {
        List<Room>rooms = new ArrayList<Room>();
        rooms = session.createCriteria(Room.class).list();
        return rooms;
    }

    @Override
    public void deleteRoom(Room room) throws Exception {
        session.beginTransaction();
        session.delete(room);
        session.getTransaction().commit();
    }

    @Override
    public Collection<Room> getRoomsOnId(int id) {
        List<Room> rooms = new ArrayList<Room>();
        Query query = session.createQuery("FROM Room WHERE userID="+Integer.toString(id)+"");
        rooms = query.list();
        return rooms;
    }

    @Override
    public Collection<Room> getFreeRoomsByType(int type) {
        List<Room> rooms = new ArrayList<Room>();
        Query query = session.createQuery("FROM Room WHERE roomType="+Integer.toString(type)+" and state=false");
        rooms = query.list();
        return rooms;
    }
}
