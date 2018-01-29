package Runnable.Unsafe2;

public class Main {
    public static void main(String[] args) {
        Counter counter=new Counter();
        Thread[] threads=new Thread[10];

        for (int i=0;i<threads.length;i++){
            threads[i]=new Thread(new Task(counter,10));
            threads[i].start();
        }

        for (Thread thread:threads){
            try {
                thread.join();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println(counter.getCounter());
    }
}
