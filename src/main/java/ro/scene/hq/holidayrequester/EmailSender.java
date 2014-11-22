package ro.scene.hq.holidayrequester;

public interface EmailSender {

    void send(String from, String to, String subject, String body);
}
