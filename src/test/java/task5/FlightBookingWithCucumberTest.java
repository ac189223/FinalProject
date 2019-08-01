package task5;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features/phptravels-flightbooking.feature",
        plugin = {"pretty", "html:out"})

public class FlightBookingWithCucumberTest {
}
