// O(n) O(n) but practical
class Logger {
    
    
    class Message {
        private String message;
        private int time;
        public Message(int time, String message){
            this.time = time;
            this.message = message;
        }
    }

    /** Initialize your data structure here. */
    Set<String> dict;
    Queue<Message> q;
    public Logger() {
        q = new LinkedList<>();
        dict = new HashSet<>();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        while(!q.isEmpty()){
            if(timestamp - q.peek().time >= 10){
                Message msg = q.poll();
                dict.remove(msg.message);
            }
            else{
                break;
            }
        }
        
        if(!dict.contains(message)){
            dict.add(message);
            q.offer(new Message(timestamp, message));
            return true;
        }
        
        return false;
    }
}


// O(1) && O(1) solution but no practical in productions
// as we record all logs in our memory.

class Logger {
    Map<String, Integer> map;
    /** Initialize your data structure here. */
    public Logger() {
        map = new HashMap<>();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(map.containsKey(message)){
            int lastPrinted = map.get(message);
            if(timestamp - lastPrinted >= 10){
                map.put(message, timestamp);
                return true;
            }
            else{
                return false;
            }
        }
        
        map.put(message, timestamp);
        return true;
    }
}

