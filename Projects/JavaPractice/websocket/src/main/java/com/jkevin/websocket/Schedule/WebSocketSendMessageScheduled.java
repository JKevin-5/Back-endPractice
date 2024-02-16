package com.jkevin.websocket.Schedule;

/**
 * @Description TODO
 * @Author JKevin
 * @Date 2024年02月16日 14:26
 * @Version 1.0
 **/
import com.jkevin.websocket.Websocket.MyWebSocketHandler;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class WebSocketSendMessageScheduled {

    @Scheduled(fixedRate = 3 * 1000)
    public void publish() {
        String msg = LocalDateTime.now().toString();
        MyWebSocketHandler.fanoutMessage(msg);
    }

}
