package com.jkevin.websocket.Dao;

import java.util.List;
import java.util.Map;

/**
 * @author mid2098
 * @version 1.0
 * @description: TODO
 * @date 2024/4/12 9:36
 */
public class Player {

    private String userName;

    private List<Token> tokens;

    public List<Token> getTokens() {
        return tokens;
    }
    public void setTokens(List<Token> tokens) {
        this.tokens = tokens;
    }
}
