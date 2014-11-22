package ro.scene.hq.holidayrequester;

import java.util.Date;

public class HolidayRequest {

    public String employeeName;
    public String employeeEmail;
    public String managerEmail;
    public String hrEmail;

    public Date fromDate;
    public Date toDate;

    public void register() {
        Email email = EmailTemplate.holidayRequestContent(employeeName, fromDate, toDate);
        email.fromEmail = employeeEmail;
        email.toEmail = managerEmail;
        email.send();
    }

    public void accept() {
        Email email = EmailTemplate.holidayRequestAcceptedContent(employeeName, fromDate, toDate);
        email.fromEmail = managerEmail;
        email.toEmail = hrEmail;
        email.send();
    }

    public void reject() {
        Email email = EmailTemplate.holidayRequestRejectedContent(fromDate, toDate);
        email.fromEmail = managerEmail;
        email.toEmail = employeeEmail;
        email.send();
    }
}
