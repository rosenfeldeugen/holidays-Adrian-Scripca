package ro.scene.hq.holidayrequester;

public class Email {
    private String subject;
    private String body;

    private Identity from;
    private Identity to;

    public void send() {
        System.out.println("From: " + from.email);
        System.out.println("To: " + to.email);
        System.out.println("Subject: " + subject);
        System.out.println("---");
        System.out.println(body);
    }

    public Email withSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public Email withBody(String body) {
        this.body = body;
        return this;
    }

    public Email from(Identity from) {
        this.from = from;
        return this;
    }

    public Email to(Identity to) {
        this.to = to;
        return this;
    }
}
