package ro.scene.hq.holidayrequester;

import java.util.Collection;

public interface EmailSender {

    void send(String from, String to, String subject, String body, Collection<String> cc);
}
