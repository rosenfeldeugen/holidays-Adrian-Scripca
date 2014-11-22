package ro.scene.hq.holidayrequester;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EmailTemplate {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");

    public static Email holidayRequestContent(String employeeName, Date from, Date to) {
        Email email = new Email();
        email.subject = "Holiday request";
        email.body = MessageFormat.format("Dear Manager\n\n" +
                "Please accept my holiday request starting from {0} until {1}.\n\n" +
                "Your slave,\n" +
                "{2}", dateFormat.format(from), dateFormat.format(to), employeeName);
        return email;
    }

    public static Email holidayRequestAcceptedContent(String employeeName, Date from, Date to) {
        Email email = new Email();
        email.subject = "Holiday request accepted";
        email.body = MessageFormat.format("Dear HR department,\n\n" +
                        "I approve the holiday request or our employee {0} which is starting on {0} and ends on {1}.\n\n" +
                        "Your dearest manager.",
                employeeName,
                dateFormat.format(from),
                dateFormat.format(to));
        return email;
    }

    public static Email holidayRequestRejectedContent(Date from, Date to) {
        Email email = new Email();
        email.subject = "Holiday request rejected";
        email.body = MessageFormat.format("My dear employee,\n\n" +
                        "Since you are so good at the work you do, I find it impossible to approve your holiday request from {0} to {1}.\n\n" +
                        "Your dearest manager.",
                dateFormat.format(from),
                dateFormat.format(to));
        return email;
    }
}
