package xyz.siddharththakkar.temu_discord.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.siddharththakkar.temu_discord.entities.Message;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findByRoomRoomIdOrderByTimeAsc(String roomId);
}