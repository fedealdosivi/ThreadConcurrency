package Runnable.simpleExample;

public class Main {
    public static void main(String[] args) {
        Thread[] threads=new Thread[5];
        for(int i=0;i<threads.length; i++){
            threads[i]=new Thread(new Task(),"Thread "+i);
            threads[i].start();
        }

        for (Thread thread:threads){
            try {
                thread.join();//block other threads until he finished
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName());
    }
}
