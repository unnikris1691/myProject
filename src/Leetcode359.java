import java.util.HashMap;
import java.util.Map;

class Logger {

    /** Initialize your data structure here. */
    public Logger() {

    }
    private HashMap<String,Integer> lastMessages = new HashMap<>();

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        Integer time = lastMessages.get(message);
        time = time == null ? -11 : time;

        if(timestamp - time  >=10){
            lastMessages.put(message,timestamp);
            return true;
        }
      return false;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */