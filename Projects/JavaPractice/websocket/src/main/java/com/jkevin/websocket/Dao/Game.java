package com.jkevin.websocket.Dao;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

public abstract class Game {

    protected ConcurrentHashMap<String,Player> players;

    public Game(){}

    // 添加玩家
    public Player addPlayers(Player player){
        return players.put(player.getUserName(),player);
    };

    // 启动
    abstract Boolean start();

    // 判断是否结束
    abstract Boolean isEnd();

    // 结束
    abstract Boolean end();

    public ConcurrentHashMap<String,Player> getPlayers(){
        return players;
    }
}
