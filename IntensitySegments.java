import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class IntensitySegments {

    private final TreeMap<Integer, Integer> segments = new TreeMap<>();

    public void add(int from, int to, int amount) {
        insertPoint(from);
        insertPoint(to);

        for (Integer key : segments.subMap(from, true, to, false).keySet()) {
            segments.put(key, segments.get(key) + amount);
        }
    }

    public void set(int from, int to, int amount) {
        insertPoint(from);
        insertPoint(to);

        for (Integer key : segments.subMap(from, true, to, false).keySet()) {
            segments.put(key, amount);
        }
    }

    private void insertPoint(int point) {
        if (!segments.containsKey(point)) {
            Map.Entry<Integer, Integer> floorEntry = segments.floorEntry(point);
            int previousValue = (floorEntry != null) ? floorEntry.getValue() : 0;
            segments.put(point, previousValue);
        }
    }

    @Override
    public String toString() {
        List<List<Integer>> result = new ArrayList<>();
        int previousValue = 0;
        for (Map.Entry<Integer, Integer> entry : segments.entrySet()) {
            int currentValue = entry.getValue();
            if (currentValue != previousValue) {
                result.add(Arrays.asList(entry.getKey(), currentValue));
                previousValue = currentValue;
            }
        }
        return result.toString().replace(" ", "");
    }

    public static void main(String[] args) {
        IntensitySegments segments = new IntensitySegments();

        // Test case 1
        System.out.println(segments);
        segments.add(10, 30, 1);
        System.out.println(segments);
        segments.add(20, 40, 1);
        System.out.println(segments);
        segments.add(10, 40, -2);
        System.out.println(segments);

        // Test case 2
        segments = new IntensitySegments();
        System.out.println(segments);
        segments.add(10, 30, 1);
        System.out.println(segments);
        segments.add(20, 40, 1);
        System.out.println(segments);
        segments.add(10, 40, -1);
        System.out.println(segments);
        segments.add(10, 40, -1);
        System.out.println(segments);
    }
}