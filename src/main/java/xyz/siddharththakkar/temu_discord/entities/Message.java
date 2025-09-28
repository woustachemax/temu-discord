package xyz.siddharththakkar.temu_discord.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Message {

    private String sender;
    private String content;
    private LocalDateTime time;

    public Message(String sender, String content){
        this.sender = sender;
        this.content =content;
        this.time = LocalDateTime.now();
    }
}
