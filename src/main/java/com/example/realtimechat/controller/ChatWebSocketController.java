package com.example.realtimechat.controller;

import com.example.realtimechat.dto.ChatMessageRequest;
import com.example.realtimechat.dto.ChatMessageResponse;
import com.example.realtimechat.service.ChatMessageService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatWebSocketController {

    private final ChatMessageService chatMessageService;

    public ChatWebSocketController(ChatMessageService chatMessageService) {
        this.chatMessageService = chatMessageService;
    }

    @MessageMapping("/chat.send")
    @SendTo("/topic/messages")
    public ChatMessageResponse sendMessage(ChatMessageRequest request) {
        return chatMessageService.save(request);
    }
}
