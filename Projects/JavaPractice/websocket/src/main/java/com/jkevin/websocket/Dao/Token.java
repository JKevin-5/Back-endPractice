package com.jkevin.websocket.Dao;

/**
 * @author mid2098
 * @version 1.0
 * @description: TODO
 * @date 2024/5/15 15:04
 */
public abstract class Token {

    // 物件名
    private String name;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Token(String name){
        this.name = name;
    }
}
