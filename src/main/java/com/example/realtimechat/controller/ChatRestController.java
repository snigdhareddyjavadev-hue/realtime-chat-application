package com.example.realtimechat.controller;

import com.example.realtimechat.dto.ChatMessageResponse;
import com.example.realtimechat.service.ChatMessageService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/messages")
public class ChatRestController {

    private final ChatMessageService chatMessageService;

    public ChatRestController(ChatMessageService chatMessageService) {
        this.chatMessageService = chatMessageService;
    }

    @GetMapping
    public List<ChatMessageResponse> recentMessages() {
        return chatMessageService.recentMessages();
    }
}
