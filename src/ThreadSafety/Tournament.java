package ThreadSafety;

import java.util.ArrayList;
import java.util.List;

public class Tournament {

    //Its safety because we have a list of winners
    //that we can access but we can not modify

    private  final List<String> winners=new ArrayList<>();

    public Tournament(List<String> winners){
        this.winners.addAll(winners);
    }

    public String getWinner(int place){
        return winners.get(place);
    }
}
