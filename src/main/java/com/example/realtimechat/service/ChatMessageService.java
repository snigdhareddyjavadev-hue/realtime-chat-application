package com.example.realtimechat.service;

import com.example.realtimechat.dto.ChatMessageRequest;
import com.example.realtimechat.dto.ChatMessageResponse;
import com.example.realtimechat.model.ChatMessage;
import com.example.realtimechat.repository.ChatMessageRepository;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ChatMessageService {

    private final ChatMessageRepository chatMessageRepository;

    public ChatMessageService(ChatMessageRepository chatMessageRepository) {
        this.chatMessageRepository = chatMessageRepository;
    }

    @Transactional
    public ChatMessageResponse save(ChatMessageRequest request) {
        String sender = sanitize(request.getSender(), "Anonymous", 60);
        String content = sanitize(request.getContent(), "", 1000);

        if (content.isBlank()) {
            throw new IllegalArgumentException("Message content cannot be empty.");
        }

        ChatMessage message = new ChatMessage();
        message.setSender(sender);
        message.setContent(content);

        return toResponse(chatMessageRepository.save(message));
    }

    @Transactional(readOnly = true)
    public List<ChatMessageResponse> recentMessages() {
        List<ChatMessageResponse> messages = chatMessageRepository.findTop50ByOrderBySentAtDesc()
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toCollection(ArrayList::new));
        Collections.reverse(messages);
        return messages;
    }

    private ChatMessageResponse toResponse(ChatMessage message) {
        return new ChatMessageResponse(
                message.getId(),
                message.getSender(),
                message.getContent(),
                message.getSentAt()
        );
    }

    private String sanitize(String value, String fallback, int maxLength) {
        String result = value == null ? fallback : value.trim();
        if (result.isBlank()) {
            result = fallback;
        }
        return result.length() > maxLength ? result.substring(0, maxLength) : result;
    }
}
