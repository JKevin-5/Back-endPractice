package com.jkevin.springbootwebsocket.controller;

import com.jkevin.springbootwebsocket.utils.WebSocket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Jkevin
 * @date 2023年07月02日 20:54
 */
@Controller
public class IndexController {

    @Autowired
    WebSocket webSocket;

    @GetMapping("/sendTo/{user}/{content}")
    @ResponseBody
    public void sendMessage(@PathVariable("user") String user,@PathVariable("content") String content) {
        webSocket.AppointSending(user,content);
    }

}
