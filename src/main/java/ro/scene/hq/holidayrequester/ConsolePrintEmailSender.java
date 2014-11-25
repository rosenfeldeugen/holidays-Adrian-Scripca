package ro.scene.hq.holidayrequester;

import java.util.Collection;

public class ConsolePrintEmailSender implements EmailSender {

    @Override
    public void send(String from, String to, String subject, String body, Collection<String> cc) {
        System.out.println("-------------------------------");
        System.out.println("Sending email");
        System.out.println("-------------------------------");
        System.out.println("From: " + from);
        System.out.println("To: " + to);

        for (String email : cc) {
            System.out.println("Cc: " + email);
        }

        System.out.println("Subject: " + subject);
        System.out.println("---");
        System.out.println(body);
    }
}
