package Locks.AtomicObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int TASKS=10;
    private static final int WAITING_TIME=5;
    private static final Long INITIAL_BALANCE=1000000L;

    public static void main(String[] args) {
        ThreadPoolExecutor executor=
                (ThreadPoolExecutor) Executors.newFixedThreadPool(TASKS);
        Account account=new Account(INITIAL_BALANCE);

        List<Future<Long>> results=new ArrayList<>(TASKS);
        for (int i=1;i<=TASKS;i++){
            results.add(executor.submit(new BankingTask(account)));
        }
        Long finalBalance=INITIAL_BALANCE;

        try {
            TimeUnit.SECONDS.sleep(WAITING_TIME);
            executor.shutdown();

            for (Future<Long> result : results){
                finalBalance+=result.get();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Final balance was " + account.getBalance() +
        " and should be "+ finalBalance);

    }
}
