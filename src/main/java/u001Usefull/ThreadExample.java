package u001Usefull;

public class ThreadExample {

    static MyThread myThread = new MyThread();

    public static void main(String[] args) {
        myThread.start();
    }
}

class MyThread extends Thread {

    public void run(){
        System.out.println("MyThread running");
    }
}
