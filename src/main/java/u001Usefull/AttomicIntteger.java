package u001Usefull;

import java.util.concurrent.atomic.AtomicInteger;

public class AttomicIntteger {
    public static void main(String[] args) {
        AtomicInteger atomic = new AtomicInteger(1);
        int number = atomic.getAndIncrement();
        System.out.println(number);
        System.out.println(atomic);
    }
}
