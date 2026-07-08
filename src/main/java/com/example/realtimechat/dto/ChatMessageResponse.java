package com.example.realtimechat.dto;

import java.time.Instant;

public class ChatMessageResponse {

    private Long id;
    private String sender;
    private String content;
    private Instant sentAt;

    public ChatMessageResponse(Long id, String sender, String content, Instant sentAt) {
        this.id = id;
        this.sender = sender;
        this.content = content;
        this.sentAt = sentAt;
    }

    public Long getId() {
        return id;
    }

    public String getSender() {
        return sender;
    }

    public String getContent() {
        return content;
    }

    public Instant getSentAt() {
        return sentAt;
    }
}
