package SynchronizedThreads.Latch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class Task implements Runnable{

    private int id;
    private int[] numbers;
    private CountDownLatch latch;
    private AtomicIntegerArray partialSums;

    public Task(int id, int[]numbers, CountDownLatch latch,
                AtomicIntegerArray partialSums){
        this.id=id;
        this.latch=latch;
        this.numbers=numbers;
        this.partialSums=partialSums;
    }

    @Override
    public void run() {
        int sum=0;
        for (int i=0; i<numbers.length; i++){
            sum+=numbers[i];
        }
        partialSums.set(id,sum);
        latch.countDown();
    }
}
