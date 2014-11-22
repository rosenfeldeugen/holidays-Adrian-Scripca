package ro.scene.hq.holidayrequester;

public class Email {
    public String from;
    public String to;
    public String subject;
    public String body;

    public void send() {
        System.out.println("From: " + from);
        System.out.println("To: " + to);
        System.out.println("Subject: " + subject);
        System.out.println("---");
        System.out.println(body);
    }
}
