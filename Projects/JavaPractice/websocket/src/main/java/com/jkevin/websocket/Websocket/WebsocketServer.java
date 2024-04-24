package com.jkevin.websocket.Websocket;

import com.alibaba.fastjson2.JSONObject;
import com.jkevin.websocket.Dao.Room;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author mid2098
 * @version 1.0
 * @description: TODO
 * @date 2024/4/23 9:15
 */
@Component
@ServerEndpoint("/websocket")
public class WebsocketServer {

    private ConcurrentHashMap<String, Room> house = new ConcurrentHashMap();

    @OnOpen
    public void onOpen(Session session) {
        System.out.println("Session: "+session.getId()+",websocket连接成功");
    }

    @OnClose
    public void onClose(Session session) {
        System.out.println("websocket连接关闭");
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        JSONObject jsonObject = JSONObject.parseObject(message);
        // 房间号不为空
        if (jsonObject.get("roomId") != null) {
            // 房间存在
            if(house.contains(jsonObject.get("roomId"))){
                Room room = house.get(jsonObject.get("roomId"));
                // 尝试获取lock
                if(room.isLocked()){
                    System.out.println(room.getRoomId()+" is locked.");
                }else{
                    room.lock();

                }
            }
        }
        System.out.println("收到"+session.getId()+"消息：" + message);
    }

    @OnError
    public void onError(Session session,Throwable error) {
        System.out.println("Session：" + session.getId() + "，websocket连接出错");
        error.printStackTrace();
    }


}
