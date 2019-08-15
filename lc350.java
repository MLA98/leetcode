class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new LinkedList<>();
        Map<Integer, Integer>  map = new HashMap<>();
        if(nums1.length > nums2.length){
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        
        for(int n1: nums1){
            int count = map.getOrDefault(n1, 0);
            map.put(n1, count + 1);
        }
        
        for(int n2: nums2){
            if(map.containsKey(n2)){
                int count = map.get(n2);
                if(count > 0){
                    list.add(n2);
                    map.put(n2, count - 1);
                }
            }
        }
        
        int[] ans = new int[list.size()];
        int index = 0;
        for(int an: list){
            ans[index] = an;
            index ++;
        }
        
        return ans;
    }
}