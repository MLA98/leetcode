// O(n)


// Time limit exceeded
class Solution {
    public int subarraysDivByK(int[] A, int K) {
        int sum = 0;
        int ans = 0;
        for(int i = 0; i < A.length; i ++){
            sum = 0;
            for(int j = i; j < A.length; j ++){
                sum = sum + A[j];
                if(sum % K == 0){
                    ans ++;
                }
            }
        }
        
        return ans;
    }
}


// O(n) + O(n)
class Solution {
    public int subarraysDivByK(int[] A, int K) {
        int ans = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap();
        map.put(0, 1);
        
        for(int a: A){
            sum = (sum + a) % K;
            if(sum < 0){
                sum += K;
            }
            int count = map.getOrDefault(sum, 0);
            ans += count;
            map.put(sum, count + 1);
        }
        
        return ans;
    }
}