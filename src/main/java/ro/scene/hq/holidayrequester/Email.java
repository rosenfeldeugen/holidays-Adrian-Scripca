package ro.scene.hq.holidayrequester;

public class Email {
    private String subject;
    private String body;

    private Identity from;
    private Identity to;

    public Email(Identity from, Identity to, String subject, String body) {
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.body = body;
    }

    public void send() {
        SystemConfiguration.EMAIL_SENDER.send(from.email, to.email, subject, body);
    }
}
