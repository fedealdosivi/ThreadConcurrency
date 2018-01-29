package executors.callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    private static final Long N=5000L;
    private static final int TASKS=5;

    public static void main(String[] args) {
        ThreadPoolExecutor executor=
                (ThreadPoolExecutor) Executors.newFixedThreadPool(TASKS);
        List<Future<Long>> results=new ArrayList<>(TASKS);

        for(int i=0; i<TASKS; i++){
            Callable<Long> task=new Task(N);
            Future<Long>result=executor.submit(task);
            results.add(result);
        }

        for (Future<Long> result : results){
                System.out.println("Obtained result:" + result);
        }
        executor.shutdown();
        System.out.println("Executor was successfully terminated");
    }
}
