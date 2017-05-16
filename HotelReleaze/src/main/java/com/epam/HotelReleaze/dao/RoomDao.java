package com.epam.HotelReleaze.dao;
import com.epam.HotelReleaze.models.Room;

import java.util.Collection;

/**
 * Created by Antoha12018 on 15.05.2017.
 */
public interface RoomDao {
    public void addRoom(Room room) throws Exception;
    public void updateRoom(Room room) throws Exception;
    public Room getRoomById(int id) throws Exception;
    public Collection<Room> getAllRooms() throws Exception;
    public void deleteRoom(Room room) throws Exception;
    public Collection<Room> getRoomsOnId(int id);
    public Collection<Room> getFreeRoomsByType(int type);
}
