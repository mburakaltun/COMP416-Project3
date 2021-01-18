package algorithms;

import simulator.NeighborInfo;

import java.util.*;

public class MinimumCostAlgorithm extends Algorithm {

    // IMPORTANT: Use this random number generator.
    Random rand = new Random(6391238);

    // IMPORTANT: You can maintain a state, e.g., a set of neighbors.
    static LinkedList<String> visited = new LinkedList<>();

    @Override
    public List<NeighborInfo> selectNeighbors(String origin, String destination, String previousHop,
                                              List<NeighborInfo> neighbors) {
        // Your code goes here.
        LinkedList<NeighborInfo> chosen = new LinkedList<>();
        if (!visited.contains(origin)) {
            visited.add(origin);
        }
        System.out.println("Exclusion set: " + visited);
        int min = 100;
        for (NeighborInfo neighborInfo : neighbors) {
            if (neighborInfo.cost < min && !visited.contains(neighborInfo.address)) {
                chosen.clear();
                chosen.add(neighborInfo);
                min = neighborInfo.cost;
            }
        }
        if (!chosen.isEmpty()) {
            if(!visited.contains(chosen.get(0).address))
                visited.add(chosen.get(0).address);
        } else {
            chosen.add(neighbors.get(rand.nextInt() % neighbors.size()));
        }
        return chosen;
    }

    @Override
    public Algorithm copy() {
        visited.clear(); // added later
        return new MinimumCostAlgorithm();
    }

    @Override
    public String getName() {
        return "MinimumCost";
    }
}
