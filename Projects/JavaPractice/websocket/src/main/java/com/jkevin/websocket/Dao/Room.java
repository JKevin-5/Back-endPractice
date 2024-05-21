package com.jkevin.websocket.Dao;

import com.alibaba.fastjson2.JSONObject;

import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author mid2098
 * @version 1.0
 * @description: TODO
 * @date 2024/4/11 8:17
 */
public class Room {

    private String roomId;

    private String roomName;

    private ReentrantLock lock;

    private JSONObject history;

    // 房主
    private String owner;

    private CopyOnWriteArraySet<Player> players;

    private Game game;

    public Room(String roomName,String playerName) {
        this.roomId = UUID.randomUUID().toString();
        this.roomName = roomName;
        this.lock = new ReentrantLock();
        this.history = new JSONObject();
        this.owner = playerName;
    }

    public JSONObject getHistory() {
        return history;
    }

    public void setHistory(JSONObject history) {
        this.history = history;
    }

    public String getRoomId() {
        return this.roomId;
    }

    public ReentrantLock getLock(){
        return lock;
    }

    public void lock() {
        lock.lock();
    }

    public void unlock() {
        lock.unlock();
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getOwner() {
        return owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return Objects.equals(roomId, room.roomId)
                && Objects.equals(game, room.game);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomId, lock, history, owner, players, game);
    }
}
