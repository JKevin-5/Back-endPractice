package com.jkevin.websocket.Websocket;

/**
 * @Description TODO
 * @Author JKevin
 * @Date 2024年02月16日 14:09
 * @Version 1.0
 **/

import com.alibaba.fastjson2.JSONObject;
import org.springframework.web.socket.*;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MyWebSocketHandler implements WebSocketHandler {

    /**
     * 房子
     */
    private static final Map<String,Map> HOUSE = new ConcurrentHashMap<>();
    
    /**
     * 房间号
     */
    private static final String RoomNo = "RoomNo";
    
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
//        String userName = session.getAttributes().get("userName").toString();
//        SESSIONS.put(userName, session);
//        System.out.println(String.format("成功建立连接~ userName: %s", userName));
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        String msg = message.getPayload().toString();
        JSONObject object = new JSONObject().putObject(msg);
        if(object.containsKey(RoomNo)&&HOUSE.containsKey(RoomNo)){
            // 进入房间
            Map<String,WebSocketSession> room = HOUSE.get(RoomNo);
            //
        }
        System.out.println(msg);
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        System.out.println("连接出错");
        if (session.isOpen()) {
            session.close();
        }
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        System.out.println("连接已关闭,status:" + closeStatus);
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }

    /**
     * 指定发消息
     *
     * @param message
     */
    public static void sendMessage(String userName, String message) {
        WebSocketSession webSocketSession = SESSIONS.get(userName);
        if (webSocketSession == null || !webSocketSession.isOpen()) {
            return;
        }

        try {
            webSocketSession.sendMessage(new TextMessage(message));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 群发消息
     *
     * @param message
     */
    public static void fanoutMessage(String message) {
        SESSIONS.keySet().forEach(us -> sendMessage(us, message));
    }

}
