package com.jkevin.websocket.Websocket;

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

    private ConcurrentHashMap house = new ConcurrentHashMap();

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
        System.out.println("收到"+session.getId()+"消息：" + message);
    }

    @OnError
    public void onError(Session session,Throwable error) {
        System.out.println("Session：" + session.getId() + "，websocket连接出错");
        error.printStackTrace();
    }


}
