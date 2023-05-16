package agents;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Agents {
    private static Map<String, Double> metrics = new HashMap<>();
    private static Map<String, Map<String, Double>> configMap = new HashMap<>();
    private static final List<String> vectorOperators = List.of("<", "<=", "==", ">=", ">");
    private static final String alphaNum = "0123456789.";

    public static void readConfig(String path) throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String line;

        while ((line = reader.readLine()) != null) {
            String[] tokens = line.split("\\s+");
            if (tokens.length < 3) {
                throw new RuntimeException("Error: bad line!");
            }
            String key = tokens[0];
            String sOperator = tokens[1];
            String sMeaning = tokens[3];

            if (!containsOperator(sOperator))
                throw new RuntimeException("Error: bad line!" + sOperator);
            if (!isAlphaNumeric(sMeaning))
                throw new RuntimeException("Error: bad line!" + sMeaning);
            configMap.put(key, Map.of(sOperator, Double.parseDouble(sMeaning)));
        }
        reader.close();
    }
    private static boolean containsOperator(String operator) {
        for (String op : vectorOperators) {
            if (op.equals(operator)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isAlphaNumeric(String s) {
        for (char c : s.toCharArray()) {
            if (!Character.isDigit(c) && c != '.') {
                return false;
            }
        }
        return true;
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
    public static void cpuAgent(String path) {}
    public static void memoryAgent(String path) {}
    public static void networkAgent(String url, String path) {}
    public static void specialAgent(String lvl, String path) {}
    public static void startBot(List<Integer> agents, String configPath, String path) {}
}
