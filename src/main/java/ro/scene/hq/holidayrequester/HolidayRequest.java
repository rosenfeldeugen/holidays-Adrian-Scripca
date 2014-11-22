package ro.scene.hq.holidayrequester;

import java.time.LocalDate;
import java.util.Date;

public class HolidayRequest {

    private Identity employee;
    private Identity manager;

    private LocalDate fromDate;
    private int days;

    public void send() {
        sendEmail(employee, manager, EmailTemplate.MailType.REQUEST);
    }

    public void accept() {
        sendEmail(manager, SystemConfiguration.HR_IDENTITY, EmailTemplate.MailType.ACCEPT);
    }

    public void reject() {
        sendEmail(manager, employee, EmailTemplate.MailType.REJECT);
    }

    public HolidayRequest fromEmployee(Identity employee) {
        this.employee = employee;
        return this;
    }

    public HolidayRequest toManager(Identity manager) {
        this.manager = manager;
        return this;
    }

    public HolidayRequest startingOn(LocalDate localDate) {
        this.fromDate = localDate;
        return this;
    }

    public HolidayRequest lastingForDays(int days) {
        this.days = days;
        return this;
    }

    private void sendEmail(Identity from, Identity to, EmailTemplate.MailType type) {
        new Email(from, to,
                EmailTemplate.getSubject(type, employee, fromDate, toDate()),
                EmailTemplate.getBody(type, employee, fromDate, toDate())).send();
    }

    private LocalDate toDate() {
        return LocalDate.from(fromDate).plusDays(days);
    }
}
