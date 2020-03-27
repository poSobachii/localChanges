package Micrometer;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import io.micrometer.core.instrument.binder.jvm.JvmThreadMetrics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;


@Configuration
public class MicrometerService {

    @Autowired
    private MeterRegistry meterRegistry;

    private Timer someNamingForTimer;
    private Counter yoItCounterBitch;

    @PostConstruct
    void postConstruct() {
        this.someNamingForTimer = meterRegistry.timer("votZdesjNadaMenjatj");
        this.yoItCounterBitch = meterRegistry.counter("totalPizdec");
    }

//    @Bean
//    JvmThreadMetrics threadMetrics(){
//        return new JvmThreadMetrics();
//    }

}