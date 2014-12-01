package ro.scene.hq.holidays;

import java.time.LocalDate;
import java.util.List;
//CR: I like fluent API but here the implementation was not the best one.
//CR: you can call accept after fromEmployee instead of submit, and without giving all the necessary data
public class HolidayRequest {

    private Identity employee;

    private Identity manager;

    private LocalDate fromDate;

    private int days;

    public void submit(DeliveryService deliveryService) {
        Email email = EmailTemplate.createSubmitEmail(employee, manager, fromDate, toDate());
        email.send(deliveryService);
    }

    public void accept(DeliveryService deliveryService) {
        Email email = EmailTemplate.createAcceptEmail(manager, employee, fromDate, toDate());
        email.ccTo(SystemConfiguration.HR_DEPARTMENT);
        email.send(deliveryService);
    }

    public void reject(DeliveryService deliveryService) {
        Email email = EmailTemplate.createRejectEmail(manager, employee, fromDate, toDate());
        email.send(deliveryService);
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
