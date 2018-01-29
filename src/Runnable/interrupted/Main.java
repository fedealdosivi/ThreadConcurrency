package Runnable.interrupted;

public class Main {
    public static void main(String[] args) {
        ThreadGroup group=new ThreadGroup("Group");

        for (int i=0;i<5; i++){
            Thread thread=new Thread(group,new Task(), "Thread"+i);
            thread.start();
        }
        group.interrupt();

        System.out.println("Finished"+Thread.currentThread().getName());
    }
}
