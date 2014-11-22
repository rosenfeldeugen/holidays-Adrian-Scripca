package ro.scene.hq.holidayrequester;

public class Email {
    public String fromEmail;
    public String toEmail;
    public String subject;
    public String body;

    public void send() {
        System.out.println("From: " + fromEmail);
        System.out.println("To: " + toEmail);
        System.out.println("Subject: " + subject);
        System.out.println("---");
        System.out.println(body);
    }
}
