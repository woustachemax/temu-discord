package xyz.siddharththakkar.temu_discord.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "rooms")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String roomId;

    private final List<Message> messages = new ArrayList<>();

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public List<Message> getMessages(){
        return new ArrayList<>(this.messages);
    }

}
