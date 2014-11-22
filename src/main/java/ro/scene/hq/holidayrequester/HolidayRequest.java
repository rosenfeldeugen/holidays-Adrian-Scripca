package ro.scene.hq.holidayrequester;

import java.time.LocalDate;
import java.util.Date;

public class HolidayRequest {

    private Identity employee;
    private Identity manager;

    private LocalDate fromDate;
    private int days;

    public void send() {
        new Email(employee, manager,
                EmailTemplate.getSubject(EmailTemplate.MailType.REQUEST, employee, fromDate, toDate()),
                EmailTemplate.getBody(EmailTemplate.MailType.REQUEST, employee, fromDate, toDate())).send();
    }

    public void accept() {
        new Email(manager, SystemConfiguration.HR_IDENTITY,
                EmailTemplate.getSubject(EmailTemplate.MailType.ACCEPT, employee, fromDate, toDate()),
                EmailTemplate.getBody(EmailTemplate.MailType.ACCEPT, employee, fromDate, toDate())).send();
    }

    public void reject() {
        new Email(manager, employee,
                EmailTemplate.getSubject(EmailTemplate.MailType.REJECT, employee, fromDate, toDate()),
                EmailTemplate.getBody(EmailTemplate.MailType.REJECT, employee, fromDate, toDate())).send();
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

    private LocalDate toDate() {
        return LocalDate.from(fromDate).plusDays(days);
    }
}
