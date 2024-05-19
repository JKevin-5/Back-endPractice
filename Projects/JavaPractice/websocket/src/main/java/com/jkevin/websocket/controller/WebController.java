package com.jkevin.websocket.controller;

import com.jkevin.websocket.Dao.House;
import com.jkevin.websocket.Dao.Player;
import com.jkevin.websocket.Dao.Room;
import com.jkevin.websocket.dto.RoomDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author mid2098
 * @version 1.0
 * @description: TODO
 * @date 2024/4/11 8:15
 */
@RestController
@RequestMapping("/game")
public class WebController {

    private House house;

    @Autowired
    public WebController(House house) {
        this.house = house;
    }

    @GetMapping("/getRooms")
    public ConcurrentHashMap<String,Room> getRooms(){
        return house.getInstance().getRooms();
    }

    @PostMapping("/addRoom")
    public Room addRoom(@RequestBody RoomDto room){
        return house.getInstance().addRoom(room.getRoomName(), room.getUserName());
    }

    @PostMapping("/addPlayer")
    public Boolean addPlayer(@RequestBody RoomDto dto){
        Room room = house.getInstance().getRoom(dto.getRoomName());
        if(null != room){
            ConcurrentHashMap<String,Player> players = room.getGame().getPlayers();
            if(players.containsKey(dto.getUserName())){
                return false;
            }else{
                players.put(dto.getUserName(),new Player(dto.getUserName()));
                return true;
            }
        }else{
            return false;
        }
    }
}
