package SynchronizedThreads.Barriers;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class Task implements Runnable{

    private int id;
    private int[] numbers;
    private CyclicBarrier barrier;
    private AtomicIntegerArray partialSums;

    public Task(int id, int[]numbers, CyclicBarrier barrier,
                AtomicIntegerArray partialSums){
        this.id=id;
        this.barrier=barrier;
        this.numbers=numbers;
        this.partialSums=partialSums;
    }

    @Override
    public void run() {
        try {
            while (true){
                int sum= Arrays.stream(numbers).reduce(Integer::sum).getAsInt();
                partialSums.set(id,sum);
                barrier.await();
            }
        }catch (Exception e){
            if (id==0 && (barrier.isBroken())){
                System.out.println("The barrier is broken.");
            }
            System.out.println(Thread.currentThread().getName());
        }
    }
}
