package com.jkevin.websocket.Dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author mid2098
 * @version 1.0
 * @description: TODO
 * @date 2024/5/16 8:44
 */
public class House {

    private static final House instance = new House();

    private ConcurrentHashMap<String,Room> rooms;

    public static House getInstance(){
        return instance;
    }

    public House(){
        // 创建空房间
        rooms = new ConcurrentHashMap<>();
    }

    public ConcurrentHashMap<String,Room> getRooms() {
        return rooms;
    }

    public Room addRoom(String roomName,String userName) {
        if(rooms.containsKey(roomName)){
            return null;
        }
        Room room = new Room(roomName,userName);
        return rooms.put(room.getRoomId(),room);
    }

    public Room getRoom(String roomName) {
        return rooms.get(roomName);
    }
}
