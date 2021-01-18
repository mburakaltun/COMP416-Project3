package algorithms;

import simulator.NeighborInfo;

import java.util.*;

public class NaiveMinimumCostAlgorithm extends Algorithm {

    @Override
    public List<NeighborInfo> selectNeighbors(String origin, String destination, String previousHop,
                                              List<NeighborInfo> neighbors) {
        // Your code goes here.
        LinkedList<NeighborInfo> chosen = new LinkedList<>();
        int min = 100;
        for(NeighborInfo neighborInfo : neighbors) {
            if(neighborInfo.cost <= min) {
                if(previousHop != null) {
                    if(neighborInfo.address.compareTo(previousHop) != 0) {
                        chosen.clear();
                        chosen.add(neighborInfo);
                        min = neighborInfo.cost;
                    }
                } else {
                    chosen.clear();
                    chosen.add(neighborInfo);
                    min = neighborInfo.cost;
                }
            }
        }
        return chosen;
    }

    @Override
    public Algorithm copy() {
        return new NaiveMinimumCostAlgorithm();
    }

    @Override
    public String getName() {
        return "NaiveMinimumCost";
    }
}
