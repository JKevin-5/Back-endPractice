package com.jkevin.websocket.Dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author mid2098
 * @version 1.0
 * @description: TODO
 * @date 2024/5/10 16:33
 */
public class Cabo extends Game{

    private static int maxPlayer = 4;
    private static int minPlayer = 2;

    // 牌堆
    private ConcurrentLinkedDeque<CaboToken> deck;

    // 弃牌堆
    private ConcurrentLinkedDeque<CaboToken> deadwood;

    public Cabo(){
        this.
    }
    @Override
    public Boolean start(){

        // 混洗牌堆
        initDeck();
        // 初始化弃牌堆
        // TODO 同步画面
        CaboToken token = initDeadwood();
        // 给玩家发牌 一人四张

        return true;
    }

    public Boolean isStart(){
        return this.players.size()>=minPlayer&&this.players.size()<=maxPlayer;
    }

    @Override
    public Boolean isEnd() {
        return null;
    }

    @Override
    public Boolean end() {
        return null;
    }

    public void initDeck(){
        // 12*4 牌 + 2*0 + 2*13
        Integer[] array = {
                1,2,3,4,5,6,7,8,9,10,11,12,
                1,2,3,4,5,6,7,8,9,10,11,12,
                1,2,3,4,5,6,7,8,9,10,11,12,
                1,2,3,4,5,6,7,8,9,10,11,12,
                0,0,13,13
        };
        List<Integer> list = Arrays.asList(array);
        // 混洗牌堆
        Collections.shuffle(list);
        // 清空已有牌堆
        this.deck = new ConcurrentLinkedDeque<>();
        for(Integer i:list){
            this.deck.push(new CaboToken(String.valueOf(i),i));
        }
    }

    private CaboToken initDeadwood(){
        CaboToken token = this.deck.pop();
        this.deadwood.push(token);
        return token;
    }

    private void initPlayer(){

    }
}
