package ThreadSafety;

public class TaskSafety implements Runnable {

    private int attribute=0;

    //this task is safety because it has local variables
    //that can only be modify in the run method

    @Override
    public void run() {
        int a=20;
        attribute+= a/2;
        a=attribute*3;
    }
}
