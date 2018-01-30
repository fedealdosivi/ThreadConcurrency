package executors.AtomicObjects;

import java.util.concurrent.atomic.AtomicLong;

public class Account {
    private AtomicLong balance;

    public Account(Long balance){
        this.balance=new AtomicLong(balance);
    }

    public Long getBalance(){
        return balance.get();
    }

    public Long add(Long amount){
        return balance.addAndGet(amount);
    }

    public Long substract(Long amount){
        return balance.addAndGet(amount*-1);
    }
}
