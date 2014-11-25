package ro.scene.hq.holidayrequester;

import java.time.LocalDate;

public class Launcher {

    public static void main(String... args) {
        new HolidayRequest()
            .fromEmployee(new Identity("benishor@gmail.com", "Adrian Scripca"))
            .toManager(new Identity("boss@iquestgroup.com", "Dilbert Boss"))
            .startingOn(LocalDate.of(2014, 11, 24))
            .lastingForDays(5)
            .send();
    }
}
