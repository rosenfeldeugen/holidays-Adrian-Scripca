package ro.scene.hq.holidays;

import java.text.MessageFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

//CR: this is not a template. Is more like a factory or a builder.
public class EmailTemplate {

    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("d MMM yyyy");
   //CR: all of these functions have the same signature (expect createAcceptEmail but you can change it)
   //CR: you can introduce here an internal state and inject the necessary parameters with a constructor ( new EmailTemplate(employee, manager, fromDate, toDate))
	
    public static Email createSubmitEmail(Identity employee, Identity manager, LocalDate fromDate, LocalDate toDate) {
        String emailBody = MessageFormat.format("Dear Manager\n\n" +
                                                "Please accept my holiday request starting from {0} until {1}.\n\n" +
                                                "Your slave,\n" +
                                                "{2}",
                                                dateFormatter.format(fromDate), dateFormatter.format(toDate), employee.name);
        return new Email(employee, manager, "Holiday request", emailBody);
    }
	//CR: all of the functions should have the same signature
    public static Email createAcceptEmail(Identity manager, Identity employee, LocalDate fromDate, LocalDate toDate) {
        String emailBody = MessageFormat.format("Dear employee,\n\n" +
                                                "Just because I am so cool, I chose to approve your holiday request starting on {1} and "
                                                + "ending on {2}.\n\n"
                                                +
                                                "Your dearest manager.",
                                                employee.name, dateFormatter.format(fromDate), dateFormatter.format(toDate));
        return new Email(manager, employee, "Holiday request accepted", emailBody);
    }

    public static Email createRejectEmail(Identity manager, Identity employee, LocalDate fromDate, LocalDate toDate) {
        String emailBody = MessageFormat.format("My dear employee,\n\n" +
                                                "Since you are so good at the work you do, I find it impossible to approve your holiday "
                                                + "request from {0} to {1}. Please try again later.\n\n"
                                                +
                                                "Your dearest manager.",
                                                dateFormatter.format(fromDate), dateFormatter.format(toDate));
        return new Email(manager, employee, "Holiday request rejected", emailBody);
    }
}
