package ro.scene.hq.holidays;

import java.util.HashSet;
import java.util.Set;

public class Email {

    private String subject;

    private String body;

    private Identity from;

    private Identity to;

    private Set<String> cc = new HashSet<>();

    public Email(Identity from, Identity to, String subject, String body) {
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.body = body;
    }

    public void ccTo(Identity identity) {
        cc.add(identity.email);
    }

    public void send(DeliveryService deliveryService) {
        deliveryService.deliver(from.email, to.email, subject, body, cc);
    }
}
