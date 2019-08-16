// Double heaps solution which is brilliant!
// O(logn) for adding
// O(1) for fetching
class MedianFinder {
    Queue<Long> small;
    Queue<Long> large;
 
    /** initialize your data structure here. */
    public MedianFinder() {
        small = new PriorityQueue<>();
        large = new PriorityQueue<>((a, b) -> b.compareTo(a));
    }
    
    public void addNum(int num) {
        if(small.size() > large.size()){
            small.offer((long)num);
            large.offer(small.poll());
        }
        else{
            large.offer((long)num);
            small.offer(large.poll());
        }
    }
    
    public double findMedian() {
        return large.size() != small.size() ? small.peek():
                        ((double)(small.peek() + large.peek()) / 2);
                                
    }
}



// Bruteforce
// O(nlgn) for add
// O(1) for median 

class MedianFinder {
    List<Integer> list;

    /** initialize your data structure here. */
    public MedianFinder() {
        list = new ArrayList<>();
    }
    
    public void addNum(int num) {
        list.add(num);
        Collections.sort(list);
    }
    
    public double findMedian() {
        if(list.size() % 2 == 0){
            double median = (double)(list.get(list.size() / 2) + list.get(list.size() / 2 - 1)) / 2;
            return median;
        }
        return list.get(list.size() / 2);
    }
}

// little bit improvement
// adding: O(n));
// fetch: O(1);
// Also, we could use bin search to save some time of 
// finding the insertion postion

class MedianFinder {
    List<Integer> list;

    /** initialize your data structure here. */
    public MedianFinder() {
        list = new ArrayList<>();
    }
    
    public void addNum(int num) {
        if(list.size() == 0){
            list.add(num);
            return;
        }
        
        
        int start = 0;
        
        if(num > list.get(list.size() / 2)){
            start = list.size() / 2;
        }
        
        for(int i = start; i < list.size(); i ++){
            if(num < list.get(i)){
                list.add(i, num);
                return;
            }
        }
        
        list.add(num);
    }
    
    public double findMedian() {
        if(list.size() % 2 == 0){
            double median = (double)(list.get(list.size() / 2) + list.get(list.size() / 2 - 1)) / 2;
            return median;
        }
        return list.get(list.size() / 2);
    }
}


