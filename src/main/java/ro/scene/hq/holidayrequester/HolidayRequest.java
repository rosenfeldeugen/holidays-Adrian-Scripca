package ro.scene.hq.holidayrequester;

import java.time.LocalDate;

public class HolidayRequest {

    private Identity employee;

    private Identity manager;

    private LocalDate fromDate;

    private int days;

    public void send() {
        Email email = EmailTemplate.createSubmitEmail(employee, manager, fromDate, toDate());
        email.send();
    }

    public void accept() {
        Email email = EmailTemplate.createAcceptEmail(manager, employee, fromDate, toDate());
        email.ccTo(SystemConfiguration.HR_IDENTITY);
        email.send();
    }

    public void reject() {
        Email email = EmailTemplate.createRejectEmail(manager, employee, fromDate, toDate());
        email.send();
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
