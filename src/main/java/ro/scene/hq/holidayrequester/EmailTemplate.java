package ro.scene.hq.holidayrequester;

import java.text.MessageFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class EmailTemplate {

    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("d MMM yyyy");

    enum MailType {
        REQUEST,
        ACCEPT,
        REJECT
    }

    public static String getSubject(MailType type) {
        switch (type) {
            case REQUEST:
                return "Holiday request";
            case ACCEPT:
                return "Holiday request accepted";
            case REJECT:
                return "Holiday request rejected";
            default:
                throw new IllegalStateException("Unknown mail type " + type);
        }
    }

    public static String getBody(MailType type, Identity employee, LocalDate from, LocalDate to) {
        switch (type) {
            case REQUEST:
                return MessageFormat.format("Dear Manager\n\n" +
                                "Please accept my holiday request starting from {0} until {1}.\n\n" +
                                "Your slave,\n" +
                                "{2}",
                        dateFormatter.format(from), dateFormatter.format(to), employee.name);
            case ACCEPT:
                return MessageFormat.format("Dear HR department,\n\n" +
                                "I approve the holiday request or our employee {0} which is starting on {1} and ends on {2}.\n\n" +
                                "Your dearest manager.",
                        employee.name, dateFormatter.format(from), dateFormatter.format(to));
            case REJECT:
                return MessageFormat.format("My dear employee,\n\n" +
                                "Since you are so good at the work you do, I find it impossible to approve your holiday request from {0} to {1}.\n\n" +
                                "Your dearest manager.",
                        dateFormatter.format(from), dateFormatter.format(to));
            default:
                throw new IllegalStateException("Unknown mail type " + type);
        }
    }
}
