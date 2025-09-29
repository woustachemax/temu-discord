package xyz.siddharththakkar.temu_discord.Services;

import org.springframework.stereotype.Service;
import xyz.siddharththakkar.temu_discord.entities.Message;
import xyz.siddharththakkar.temu_discord.entities.Room;
import xyz.siddharththakkar.temu_discord.payload.MessageRequest;
import xyz.siddharththakkar.temu_discord.repositories.MessageRepository;
import xyz.siddharththakkar.temu_discord.repositories.RoomRepository;

import java.time.LocalDateTime;

@Service
public class MessageService {
    private final RoomRepository roomRepository;
    private final MessageRepository messageRepository;

    public MessageService(RoomRepository roomRepository, MessageRepository messageRepository){
        this.roomRepository = roomRepository;
        this.messageRepository = messageRepository;
    }

    public Message sendMessage(MessageRequest request, String roomId){
        Room room = roomRepository.findByRoomId(roomId);
        if (room == null) {
            throw new IllegalArgumentException("Room not found");
        }

        Message message = new Message();
        message.setSender(request.getSender());
        message.setContent(request.getContent());
        message.setTime(LocalDateTime.now());
        message.setRoom(room);

        return messageRepository.save(message);
    }
}