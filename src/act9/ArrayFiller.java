package act9;

import java.util.Random;

public class ArrayFiller implements Runnable {

    int latency;
    int minValue, maxValue;
    int from, to;
    static Random random;


    public ArrayFiller(int latency, int minValue, int maxValue) {

        cons(latency, minValue, maxValue, 0, 0);

    }

    public ArrayFiller(int latency, int minValue, int maxValue, int from, int to) {
        cons(latency, minValue, maxValue, from, to);
    }

    public ArrayFiller() {

    }

    private void cons(int latency, int minValue, int maxValue, int from, int to){
        this.latency = latency;
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.from = from;
        this.to = to;
        this.random = new Random();
    }

    @Override
    public void run() {
        try {
            Thread.sleep(latency);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
            return;
        }
        for (int i = from; i <= to; i++){
            ArrayFillerManager.array[i] = this.random.nextInt(maxValue + 1 - minValue) + minValue;
        }

    }

//	private int randomFill() {
//			int avg = maxValue - minValue;
//	        int randomNum = random.nextInt(minValue) + avg;
//	        return randomNum;
//	}
}