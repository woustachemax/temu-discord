package xyz.siddharththakkar.temu_discord.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.siddharththakkar.temu_discord.entities.Room;

public interface  RoomRepository extends JpaRepository<Room, String> {

    Room findByRoomId(String roomId);
}
