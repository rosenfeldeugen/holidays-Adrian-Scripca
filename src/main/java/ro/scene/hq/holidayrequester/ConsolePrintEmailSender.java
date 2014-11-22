package ro.scene.hq.holidayrequester;

public class ConsolePrintEmailSender implements EmailSender {

    @Override
    public void send(String from, String to, String subject, String body) {
        System.out.println("-------------------------------");
        System.out.println("Sending email");
        System.out.println("-------------------------------");
        System.out.println("From: " + from);
        System.out.println("To: " + to);
        System.out.println("Subject: " + subject);
        System.out.println("---");
        System.out.println(body);
    }
}
