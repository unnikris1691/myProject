import javax.print.DocFlavor;
import java.util.HashMap;
import java.util.Map;


class AllOne {
    HashMap<String, Integer> keyValue;
    static String maxKey="";
    private static String minKey="";

    int minValue = Integer.MAX_VALUE;
    int maxValue = Integer.MIN_VALUE;

    /**
     * Initialize your data structure here.
     */
    public AllOne() {
        keyValue = new HashMap<>();

    }

    /**
     * Inserts a new key <Key> with value 1. Or increments an existing key by 1.
     */
    public void inc(String key) {
        keyValue.merge(key, 1, Integer::sum);
        determineMinMax(key);

    }

    private void determineMinMax(String key) {
        if (keyValue.get(key) > maxValue) {
            maxValue = keyValue.get(key);
            maxKey = key;
        }
        if (keyValue.get(key) < minValue) {
            minValue = keyValue.get(key);
            minKey = key;
        }
    }

    /**
     * Decrements an existing key by 1. If Key's value is 1, remove it from the data structure.
     */
    public void dec(String key) {
        if (keyValue.size() == 0) {
            return;
        }
        if (keyValue.get(key) == 1) {
            keyValue.remove(key);
        } else {
            keyValue.put(key, keyValue.get(key) - 1);
        }
        determineMinMax(key);
    }

    /**
     * Returns one of the keys with maximal value.
     */
    public String getMaxKey() {
        return maxKey;
    }

    /**
     * Returns one of the keys with Minimal value.
     */
    public String getMinKey() {
       return minKey;
    }

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
}
