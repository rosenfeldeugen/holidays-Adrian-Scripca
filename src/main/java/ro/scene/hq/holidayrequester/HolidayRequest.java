package ro.scene.hq.holidayrequester;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HolidayRequest {

    public String employeeName;
    public String employeeEmail;
    public String managerEmail;
    public String hrEmail;

    public Date from;
    public Date to;

    public void register() {
        Email email = new Email();
        email.from = employeeEmail;
        email.to = managerEmail;
        email.subject = "Holiday request";
        email.body = holidayRequestContent();

        email.send();
    }

    public void accept() {
        Email email = new Email();
        email.from = managerEmail;
        email.to = hrEmail;
        email.subject = "Holiday request accepted";
        email.body = holidayRequestAcceptedContent();
        email.send();
    }

    public void reject() {
        Email email = new Email();
        email.from = managerEmail;
        email.to = employeeEmail;
        email.subject = "Holiday request rejected";
        email.body = holidayRequestRejectedContent();
        email.send();
    }

    private String holidayRequestContent() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        return MessageFormat.format("Dear Manager\n\n" +
                "Please accept my holiday request starting from {0} until {1}.\n\n" +
                "Your slave,\n" +
                "{2}", dateFormat.format(from), dateFormat.format(to), employeeName);
    }

    private String holidayRequestAcceptedContent() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        return MessageFormat.format("Dear HR department,\n\n" +
                        "I approve the holiday request or our employee {0} which is starting on {0} and ends on {1}.\n\n" +
                        "Your dearest manager.",
                employeeName,
                dateFormat.format(from),
                dateFormat.format(to));
    }

    private String holidayRequestRejectedContent() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        return MessageFormat.format("My dear employee,\n\n" +
                        "Since you are so good at the work you do, I find it impossible to approve your holiday request from {0} to {1}.\n\n" +
                        "Your dearest manager.",
                dateFormat.format(from),
                dateFormat.format(to));
    }
}
