package algorithms;

import simulator.NeighborInfo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Implements a flooding routing algorithm that converges.
 */
public class FloodingAlgorithm extends Algorithm {

    // IMPORTANT: You can maintain a state, e.g., a flag.
    List<String> previousHops = new LinkedList<>(); // maintain visited nodes

    @Override
    public List<NeighborInfo> selectNeighbors(String origin, String destination, String previousHop,
                                              List<NeighborInfo> neighbors) {
        // Find the list of neighbors, excluding the previous hop.
        previousHops.add(previousHop);
        List<NeighborInfo> chosen = new LinkedList<>();
        for(NeighborInfo neighborInfo : neighbors) {
            if(!previousHops.contains(neighborInfo.address)) {
                chosen.add(neighborInfo);
            }
        }
        // Return the chosen nodes.
        return chosen;
    }

    @Override
    public Algorithm copy() {
        return new FloodingAlgorithm();
    }

    @Override
    public String getName() {
        return "Flooding";
    }
}
