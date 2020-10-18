import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Flow {
    static AtomicInteger totalSum = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        long startTime1 = System.currentTimeMillis();
        ArrayList<Thread> threads = new ArrayList<>();

        for (int i=0;i<10;i++){
            work(i);
        }

        long endTime1 = System.currentTimeMillis();
        System.out.println("total time: " + (endTime1 - startTime1));
        System.out.println("total sum: " + totalSum.get());

        ///////////////////////////////////////////////////////////////////////////////////////////

        long startTime2 = System.currentTimeMillis();

        for (int i = 0; i < 10; i++){
            final int localI = i;
            Thread thread = new Thread(() -> work(localI));
            thread.start();
            threads.add(thread);
        }

        for (Thread t : threads) {
            t.join();
        }

        long endTime2 = System.currentTimeMillis();
        System.out.println("total time: " + (endTime2 - startTime2));
        System.out.println("total sum: " + totalSum.get());
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////

    private static void work(int i) {
        long startTime = System.currentTimeMillis();
        long result = doHardWork(i * 1000, 100_000_000);
        long endTime = System.currentTimeMillis();
        System.out.println(i + ": " + result + " | " + (endTime-startTime));
    }

    private static long doHardWork(int start, int count) {
        long a = 0;
        for (int i = 0; i < count; i++) {
            a += (start + i) * (start + i) * Math.sqrt(start + i);
            totalSum.getAndIncrement();
        }
        return a;
    }
}