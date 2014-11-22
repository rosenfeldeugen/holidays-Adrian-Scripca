package ro.scene.hq.holidayrequester;

import java.time.LocalDate;

public class Launcher {
    public static void main(String... args) {
        new HolidayRequest()
                .fromEmployee(Identity.fromEmailAndName("benishor@gmail.com", "Adrian Scripca"))
                .toManager(Identity.fromEmail("boss@iquestgroup.com"))
                .startingOn(LocalDate.of(2014, 11, 24))
                .lastingForDays(5)
                .send();
    }
}
