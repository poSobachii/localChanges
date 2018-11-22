package x007act7;

import java.util.LinkedList;


public class ArrayFillerManager {
    static int[] array;
    static int latency;
    static int minValue, maxValue;
    private static LinkedList<Thread> threads;

    public static int[] setUp(int arraySize, int latency, int minValue, int maxValue) {
        array = new int [arraySize];
        ArrayFillerManager.latency = latency;
        ArrayFillerManager.minValue = minValue;
        ArrayFillerManager.maxValue = maxValue;
        threads = new LinkedList<>();
        return array;
    }

    public static void fillStupidly() {
        try {
            Thread.sleep(latency * 30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < array.length; i++) {
            Thread thread = new Thread(new ArrayFiller(latency, minValue, maxValue, i, i));
            thread.start();
        }

    }

    public static void fillSequentially() {
        try {
            Thread.sleep(latency * 20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int from = 0;
        int to = array.length - 1;
        ArrayFiller filler = new ArrayFiller(latency, minValue, maxValue, from, to);
        filler.run();

    }

    public static void fillParalelly() {

        int from = 0;
        int to = array.length / 16 ;

        for (int i = 0; i < 16; i++) {

            threads.add(new Thread(new ArrayFiller(latency, minValue, maxValue, from, to)));
            try {
                threads.get(i).join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            threads.get(i).start();
            from = to;
            to += to;
            if (to > array.length - 1) {
                to = array.length - 1;
            }
        }
    }

}
