package u001Usefull;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class DurationDemo {
    public static void main(String[] args) {

        Duration duration = Duration.ofMillis(5000);
        System.out.println(duration.getSeconds());

        Duration duration2 = Duration.of(System.currentTimeMillis(), ChronoUnit.MILLIS);
        System.out.println(duration2.toMillis());
    }
}
