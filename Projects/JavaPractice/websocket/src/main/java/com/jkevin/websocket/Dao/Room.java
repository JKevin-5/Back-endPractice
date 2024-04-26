package com.jkevin.websocket.Dao;

import com.alibaba.fastjson2.JSONObject;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author mid2098
 * @version 1.0
 * @description: TODO
 * @date 2024/4/11 8:17
 */
public class Room {

    private String roomId;

    private ReentrantLock lock;

    private JSONObject history;

    public Room(String roomId) {
        this.roomId = roomId;
        this.lock = new ReentrantLock();
        this.history = new JSONObject();
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
}
