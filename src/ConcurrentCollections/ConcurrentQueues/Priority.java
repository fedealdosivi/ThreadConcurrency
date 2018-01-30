package ConcurrentCollections.ConcurrentQueues;

import java.util.Comparator;

public class Priority implements Comparator<Message> {

    public final static int HIGH=1;
    public final static int MEDIUM=2;
    public final static int LOW=3;

    @Override
    public int compare(Message o1, Message o2) {
        return Integer.compare(o1.getPriority(), o2.getPriority());
    }

    public static String getPriorityName(int priority){
        switch (priority){
            case Priority.HIGH: return "HIGH";
            case Priority.MEDIUM: return "MEDIUM";
            case Priority.LOW: return "LOW";
            default: return "INVALID";
        }
    }
}
