package executors.AtomicObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;

public class BankingTask implements Callable<Long> {

    private Account account;
    private List<Long> movements=new ArrayList<>();

    public BankingTask(Account account){
        this.account=account;
    }

    @Override
    public Long call() throws Exception {
        Random random=new Random();

        while (!Thread.interrupted()){
            Long amount=random.nextLong()*10000;

            if (random.nextBoolean()){
                account.add(amount);
                movements.add(amount);
            }else {
                account.substract(amount);
                movements.add(-1*amount);
            }
        }

        System.out.println(Thread.currentThread().getName()+
        " performed" + movements.size() + " operations");
        return movements.stream().reduce(0L,Long::sum);
    }
}
