package ro.scene.hq.holidays;

import java.util.Collection;
//CR: we don't need a delivery service. We only have to send an email.
public interface DeliveryService {

	//CR:There is no scenario where cc is needed.
    void deliver(String from, String to, String subject, String body, Collection<String> cc);
}
