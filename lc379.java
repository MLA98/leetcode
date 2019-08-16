// sb force
// O(n) for get(), O(1) for every one else;
// O(n) space;
class PhoneDirectory {
    boolean[] nums;

    /** Initialize your data structure here
        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public PhoneDirectory(int maxNumbers) {
        nums = new boolean[maxNumbers];
    }
    
    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    public int get() {
        for(int i = 0; i < nums.length; i++){
            if(!nums[i]){
                nums[i] = true;
                return i;
            }
        }
        
        return -1;
    }
    
    /** Check if a number is available or not. */
    public boolean check(int number) {
        return !nums[number];
    }
    
    /** Recycle or release a number. */
    public void release(int number) {
        nums[number] = false;
    }
}

// O(n) for init and O(1) for everything else using Queue and set. 
// O(n) space
class PhoneDirectory {
    Queue<Integer> available;
    Set<Integer> used;
    int max;
    public PhoneDirectory(int maxNumbers) {
        available = new LinkedList<>();
        used = new HashSet<>();
        max = maxNumbers;
        for(int i = 0; i < maxNumbers; i ++){
            available.offer(i);
        }
    }
    
    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    public int get() {
        Integer ret = available.poll();
        if (ret == null) {
            return -1;
        }
        used.add(ret);
        return ret;
    }
    
    /** Check if a number is available or not. */
    public boolean check(int number) {
        if (number >= max || number < 0) {
            return false;
        }

        return !used.contains(number);
    }
    
    /** Recycle or release a number. */
    public void release(int number) {
        if(used.contains(number)){
            available.offer(number);
            used.remove(number);
        }
    }
}
