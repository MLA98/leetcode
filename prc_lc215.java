class Solution {
    // O(nlogk) logk is the complexity of each insert 
    // and we do it n times.
    // O(logk) is for inserting cuz it basically a tree internally.
    public int findKthLargest(int[] nums, int k) {
        // 遇到了神奇操作
        // new 那个后面的括号里就是comparator构造来构建权重分配
        PriorityQueue<Integer> head = new PriorityQueue<>((n1, n2) -> n1 - n2);
        
        for(int n: nums){
            head.add(n);
            if(head.size() > k){
                head.poll();
            }
        }
        return head.poll();
    }
}

// Quick select solution
// why O(n)? : each time we call it, we shrink the size into average half
// O(n) + O(n/2) + .... = O(2n) => O(n)
// space O(1)
class Solution {
    private int[] nums;
    public int findKthLargest(int[] nums, int k) {
        // Quick select
        this.nums = nums;
        return quickselect(0, nums.length - 1, nums.length - k);
    }
    
    private int quickselect(int start, int end, int k){
        if(start == end){
            return this.nums[end];
        }
        
        Random random = new Random();
        int pivot = start + random.nextInt(end -start);
        pivot = partition(start, end, pivot);
        
        if(pivot == k){
            return this.nums[pivot];
        }
        else if(pivot > k){
            return quickselect(start, pivot - 1, k);
        }
        
        return quickselect(pivot + 1, end, k);
    }
    
    private int partition(int start, int end, int pivot){
        swap(pivot, end);
        int smallIndex = start;
        for(int i = start; i <= end; i ++){
            if(this.nums[i] < this.nums[end]){
                swap(smallIndex, i);
                smallIndex ++;
            }
        }
        swap(smallIndex, end);
    }
    
    private void swap(int a, int b){
        int temp = this.nums[a];
        this.nums[a] = this.nums[b];
        this.nums[b] = temp;
    }
}