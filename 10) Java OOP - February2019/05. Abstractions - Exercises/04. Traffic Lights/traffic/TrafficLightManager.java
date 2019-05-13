package traffic;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.HashMap;

public class TrafficLightManager {

    private ArrayDeque<String> trafficLights;

    private HashMap<Integer, String> cachedOutput;

    public TrafficLightManager(String[] inputLights) {
        setInputLights(inputLights);
        cachedOutput = new HashMap<>();
    }

    public String getTrafficOutput(int i) {
        int nThShuffle = i % trafficLights.size();

        if (cachedOutput.containsKey(nThShuffle)) {
            return cachedOutput.get(nThShuffle);
        }

        shuffleTrafficLights();
        cachedOutput.put(i, this.toString());
        return cachedOutput.get(i);
    }

    private void setInputLights(String[] inputLights) {
        trafficLights = new ArrayDeque<>();
        Collections.addAll(trafficLights, inputLights);
    }

    private void shuffleTrafficLights() {
        trafficLights.addFirst(trafficLights.removeLast());
    }

    @Override
    public String toString() {
        return String.join(" ", trafficLights);
    }
}
