package Chapter0_JavaBasic.FundamentalsofMultithreading;

public class MultiThreading extends Thread{
    public void run() {
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + " is running.");
        }
    }
    public static void main(String[] args) {
        MultiThreading t1 = new MultiThreading();
        MultiThreading t2 = new MultiThreading();
        t1.start();
        t2.start();
    }
}
