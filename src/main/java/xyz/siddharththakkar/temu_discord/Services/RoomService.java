package xyz.siddharththakkar.temu_discord.Services;

import org.springframework.stereotype.Service;
import xyz.siddharththakkar.temu_discord.entities.Message;
import xyz.siddharththakkar.temu_discord.entities.Room;
import xyz.siddharththakkar.temu_discord.repositories.RoomRepository;

import java.util.List;

@Service
public class RoomService {

    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public Room createRoom(String roomId) {
        if (roomRepository.findByRoomId(roomId) != null) {
            throw new IllegalArgumentException("This Room already exists!");
        }
        Room room = new Room();
        room.setRoomId(roomId);
        return roomRepository.save(room);
    }

    public Room joinRoom(String roomId) {
        Room room = roomRepository.findByRoomId(roomId);
        if (room == null) {
            throw new IllegalArgumentException("No such room exists, please create one!");
        }
        return room;
    }

    public List<Message> getMessages(String roomId) {
        Room room = roomRepository.findByRoomId(roomId);
        if (room == null) {
            throw new IllegalArgumentException("No such room exists");
        }
        return room.getMessages();
    }

}
