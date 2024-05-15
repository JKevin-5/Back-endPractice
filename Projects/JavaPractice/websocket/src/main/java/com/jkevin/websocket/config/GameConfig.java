package com.jkevin.websocket.config;

import com.jkevin.websocket.Dao.Cabo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author mid2098
 * @version 1.0
 * @description: TODO
 * @date 2024/5/15 20:06
 */
@Configuration
public class GameConfig {

    @Bean
    public Cabo getCabo(){
        return Cabo.getInstance();
    }
}
