package agents;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Agents {
    private static Map<String, Double> metrics = new HashMap<>();
    private static Map<String, Map<String, Double>> configMap = new HashMap<>();
    private static final List<String> vectorOperators = List.of("<", "<=", "==", ">=", ">");
    private static final String alphaNum = "0123456789.";

    public static void readConfig(String path) {

    }
    public static void startingAgents(String lvl, String url, List<Integer> agents, String path) {

    }
    public void compareMaps() {}
    public void checkMetrics() {
        for (Map.Entry<String, Double> entry : metrics.entrySet()) {
            System.out.println(entry.getKey() + " | " + entry.getValue());
        }
    }
    public void checkConfig() {
        for (Map.Entry<String, Map<String, Double>> entry : configMap.entrySet()) {
            String key = entry.getKey();
            Map<String, Double> value = entry.getValue();
            System.out.println(key + " | " + value.get("first") + " | " + value.get("second"));
        }
    }
}
