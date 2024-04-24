package com.jkevin.websocket.Dao;

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

    private String history;

    public Room(String roomId) {
        this.roomId = roomId;
        this.lock = new ReentrantLock();
        this.history = "";
    }

    public String getRoomId() {
        return this.roomId;
    }

    public Boolean isLocked(){
        return this.lock.isLocked();
    }

    public void lock() {
        lock.lock();
    }

    public void unlock() {
        lock.unlock();
    }
}
