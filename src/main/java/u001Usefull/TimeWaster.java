package u001Usefull;

import java.util.concurrent.TimeUnit;

public class TimeWaster {
    public static void main(String[] args) throws InterruptedException {
        @SuppressWarnings({"PMD.ExcessiveMethodLength"})
        int delay = 1;
        System.out.println("Preparing your coffee...");
        TimeUnit.SECONDS.sleep(delay);
        System.out.println("..adding Ingridient.....");
        TimeUnit.SECONDS.sleep(delay);
        System.out.println(".....adding Water.......");
        TimeUnit.SECONDS.sleep(delay);
        System.out.println("........Heating it up...");
        TimeUnit.SECONDS.sleep(delay);
        System.out.println("...........adding Milk..");
        TimeUnit.SECONDS.sleep(delay);
        System.out.println("Done, Enjoy it !");
    }
}
