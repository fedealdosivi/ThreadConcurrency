package Unsafe2;

public class Task implements Runnable{
    private Counter counter;
    private int times;

    public Task(Counter counter,int times){
        this.counter=counter;
        this.times=times;
    }

    @Override
    public void run() {
        for (int i=0;i<times;i++){
            counter.increment();
        }
    }
}
