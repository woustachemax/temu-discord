package xyz.siddharththakkar.temu_discord.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "messages")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sender;
    private String content;
    private LocalDateTime time;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    public Message() {
    }

//    public Message(String sender, String content) {
//        this.sender = sender;
//        this.content = content;
//        this.time = LocalDateTime.now();
//    }
public Message(String sender, String content) {
    this.sender = sender;
    this.content = content;
    this.time = LocalDateTime.now();
}

    // Getters
    public Long getId() {
        return id;
    }

    public String getSender() {
        return sender;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public Room getRoom() {
        return room;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public void setRoom(Room room) {
        this.room = room;
    }



}