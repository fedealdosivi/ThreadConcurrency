package executors.Executor;

import java.time.LocalTime;

public class MyTask implements Runnable{

    private String name;

    public MyTask(String name){

    }

    @Override
    public void run() {
        System.out.println(LocalTime.now() +": "+
        Thread.currentThread().getName()+ "is exeuting"+ name);
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
