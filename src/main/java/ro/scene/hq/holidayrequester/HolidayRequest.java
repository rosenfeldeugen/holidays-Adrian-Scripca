package ro.scene.hq.holidayrequester;

import java.time.LocalDate;
import java.util.Date;

public class HolidayRequest {

    private Identity employee;
    private Identity manager;

    private LocalDate fromDate;
    private int days;

    public void send() {
        LocalDate toDate = LocalDate.from(fromDate).plusDays(days);
        EmailTemplate.employeeRequestingHoliday(employee, fromDate, toDate)
                .from(employee)
                .to(manager)
                .send();
    }

    public void accept() {
        EmailTemplate.managerAcceptingRequest(employee, fromDate, toDate())
                .from(manager)
                .to(SystemConfiguration.HR_IDENTITY)
                .send();
    }

    private LocalDate toDate() {
        return LocalDate.from(fromDate).plusDays(days);
    }

    public void reject() {
        EmailTemplate.managerRejectingRequest(fromDate, toDate())
                .from(manager)
                .to(employee)
                .send();
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
}
