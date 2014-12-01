package ro.scene.hq.holidays;

import java.time.LocalDate;

public class Launcher {

    public static void main(String... args) {
        DeliveryService deliveryService = new DeliveryServiceConsole();
	//CR: what's happened if I write in this way?
	//CR: new HolidayRequest()
			//.lastingForDays(5)
            //.accept()

        new HolidayRequest()
            .fromEmployee(new Identity("benishor@gmail.com", "Adrian Scripca"))
            .toManager(new Identity("boss@iquestgroup.com", "Dilbert Boss"))
            .startingOn(LocalDate.of(2014, 11, 24))
            .lastingForDays(5)
            .submit(deliveryService);
    }
}
