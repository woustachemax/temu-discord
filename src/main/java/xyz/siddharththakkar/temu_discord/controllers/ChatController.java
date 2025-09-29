package xyz.siddharththakkar.temu_discord.controllers;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import xyz.siddharththakkar.temu_discord.Services.MessageService;
import xyz.siddharththakkar.temu_discord.entities.Message;
import xyz.siddharththakkar.temu_discord.payload.MessageRequest;

@Controller
@CrossOrigin("http://localhost:3000")
public class ChatController {

    private final MessageService messageService;

    public ChatController(MessageService messageService){
        this.messageService = messageService;
    }

    @MessageMapping("/sendMessage/{roomId}")
    @SendTo("/topic/room/{roomId}")
    public Message sendMessage(
            @DestinationVariable String roomId,
            MessageRequest request
    ){
        return messageService.sendMessage(request, roomId);
    }
}