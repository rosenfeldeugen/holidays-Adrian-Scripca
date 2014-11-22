package ro.scene.hq.holidayrequester;

import java.util.Date;

public class Launcher {

    public static void main(String... args) {
        HolidayRequest request = new HolidayRequest();

        request.employeeEmail = "benishor@gmail.com";
        request.employeeName = "Adrian Scripca";
        request.managerEmail = "boss@iquestgroup.com";
        request.hrEmail = "hr@iquestgroup.com";

        request.fromDate = new Date(System.currentTimeMillis());
        request.toDate = new Date(System.currentTimeMillis() + 24 * 3600 * 1000);

        request.register();
    }
}
