package com.jkevin.websocket.Websocket;

import com.alibaba.fastjson2.JSONObject;
import com.jkevin.websocket.Dao.Room;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author mid2098
 * @version 1.0
 * @description: TODO
 * @date 2024/4/23 9:15
 */
@Component
@ServerEndpoint("/game/{roomName}/{userName}")
public class WebsocketServer {

    private ConcurrentHashMap<String, Room> house = new ConcurrentHashMap();

    @OnOpen
    public void onOpen(Session session) {
        // 确认房间有位置，就可以加入房间
        // 当前用户的在线状态设置为true
        // 通知房间内存在的玩家(在线、断线重连)
        System.out.println("Session: "+session.getId()+",websocket连接成功");
    }

    @OnClose
    public void onClose(Session session) {
        // 当前用户的在线状态设置为false
        // 通知房间内存在的玩家(掉线)
        System.out.println("websocket连接关闭");
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        JSONObject jsonObject = JSONObject.parseObject(message);
        // 房间号不为空
        if (jsonObject.get("roomId") != null) {
            // 房间存在
            if(house.containsKey(jsonObject.get("roomId"))){
                Room room = house.get(jsonObject.get("roomId"));
                // 尝试获取lock
                if(room.getLock().tryLock()){
                    System.out.println(room.getRoomId()+" tryLock is Ok.");
                    JSONObject object = room.getHistory();
                    String content = object.getString("message");
                    object.put("message",content+jsonObject.get("message").toString());
                    room.setHistory(object);
                    room.unlock();
                }else{
                    System.out.println(room.getRoomId()+" is locked.");
                }
            }else{
                // 房间不存在则创建房间
                Room room = new Room(jsonObject.get("roomId").toString(),"owner");
                house.put(room.getRoomId(), room);
                room.lock();
                JSONObject object = room.getHistory();
                object.put("message",jsonObject.get("message").toString());
                room.setHistory(object);
                room.unlock();
            }
            try {
                session.getBasicRemote().sendText(house.get(jsonObject.get("roomId")).getHistory().toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("收到"+session.getId()+"消息：" + message);
    }

    @OnError
    public void onError(Session session,Throwable error) {
        // 当前用户的在线状态设置为false
        // 通知房间内存在的玩家(掉线)
        System.out.println("Session：" + session.getId() + "，websocket连接出错");
        error.printStackTrace();
    }


}
