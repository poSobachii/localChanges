package u001Usefull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class SyncCollections {

    static List<Integer> syncCollection = Collections.synchronizedList(new ArrayList<>());
//    static Collection<Integer> syncCollection = Collections.synchronizedCollection(new ArrayList<>());

    public static void main(String[] args) throws InterruptedException {
        Runnable listOperations = () -> {
            doSmth();
        };

        Thread thread1 = new Thread(listOperations);
        Thread thread2 = new Thread(listOperations);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();


        System.out.println("size is = " + syncCollection.size());
    }


    static synchronized void doSmth() {
        if (syncCollection.isEmpty()) {
            syncCollection.addAll(Arrays.asList(1, 2, 3, 4, 5, 6));
        }
    }
}

