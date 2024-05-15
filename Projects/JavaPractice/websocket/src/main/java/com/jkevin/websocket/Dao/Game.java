package com.jkevin.websocket.Dao;

import java.util.concurrent.CopyOnWriteArraySet;

public abstract class Game {

    protected CopyOnWriteArraySet<Client> players;

    public Game(){}

    // 添加玩家
    public Boolean addPlayers(Client client){
        return players.add(client);
    };

    // 启动
    abstract Boolean start();

    // 判断是否结束
    abstract Boolean isEnd();

    // 结束
    abstract Boolean end();


}
