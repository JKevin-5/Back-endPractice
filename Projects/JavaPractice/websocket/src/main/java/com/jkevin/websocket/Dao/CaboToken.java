package com.jkevin.websocket.Dao;

/**
 * @author mid2098
 * @version 1.0
 * @description: TODO
 * @date 2024/5/15 15:04
 */
public class CaboToken extends Token{

    private Integer value;

    public CaboToken(String name,Integer value) {
        super(name);
        this.value = value;
    }
}
