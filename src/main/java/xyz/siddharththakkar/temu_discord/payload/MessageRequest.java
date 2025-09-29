package xyz.siddharththakkar.temu_discord.payload;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MessageRequest {

    private String content;
    private String sender;
    private String roomId;

    private LocalDateTime messageTime;


    public String getRoomId(){
        return this.roomId;
    }

    public MessageRequest() {
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
