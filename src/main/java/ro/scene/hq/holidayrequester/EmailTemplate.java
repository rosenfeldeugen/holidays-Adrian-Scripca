package ro.scene.hq.holidayrequester;

import java.text.MessageFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class EmailTemplate {

    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("d MMM yyyy");

    public static Email employeeRequestingHoliday(Identity employee, LocalDate from, LocalDate to) {
        return new Email()
                .withSubject("Holiday request")
                .withBody(MessageFormat.format("Dear Manager\n\n" +
                        "Please accept my holiday request starting from {0} until {1}.\n\n" +
                        "Your slave,\n" +
                        "{2}", dateFormatter.format(from), dateFormatter.format(to), employee.name));
    }

    public static Email managerAcceptingRequest(Identity employee, LocalDate from, LocalDate to) {
        return new Email()
                .withSubject("Holiday request accepted")
                .withBody(MessageFormat.format("Dear HR department,\n\n" +
                                "I approve the holiday request or our employee {0} which is starting on {1} and ends on {2}.\n\n" +
                                "Your dearest manager.",
                        employee.name, dateFormatter.format(from), dateFormatter.format(to)));
    }

    public static Email managerRejectingRequest(LocalDate from, LocalDate to) {
        return new Email()
                .withSubject("Holiday request rejected")
                .withBody(MessageFormat.format("My dear employee,\n\n" +
                                "Since you are so good at the work you do, I find it impossible to approve your holiday request from {0} to {1}.\n\n" +
                                "Your dearest manager.",
                        dateFormatter.format(from), dateFormatter.format(to)));
    }
}
