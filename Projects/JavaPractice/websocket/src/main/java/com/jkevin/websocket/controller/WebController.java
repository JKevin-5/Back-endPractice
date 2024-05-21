package com.jkevin.websocket.controller;

import com.jkevin.websocket.Dao.Room;
import com.jkevin.websocket.dto.RoomDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author mid2098
 * @version 1.0
 * @description: TODO
 * @date 2024/4/11 8:15
 */
@RestController
@RequestMapping("/game")
public class WebController {

    private CopyOnWriteArrayList<Room> rooms = new CopyOnWriteArrayList<>();

    @Autowired
    public WebController() {}

    @GetMapping("/getRooms")
    public CopyOnWriteArrayList<Room> getRooms(){
        return rooms;
    }

    @PostMapping("/addRoom")
    public Room addRoom(@RequestBody RoomDto roomDto){
        Room room = new Room(roomDto.getRoomName(), roomDto.getUserName());
        if(rooms.add(room)){
            return room;
        }else{
            return null;
        }
    }
}
