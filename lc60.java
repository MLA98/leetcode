class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> list = new ArrayList<>();
        int[] fac = new int[n + 1];
        int fact = 1;
        fac[0] = 1;
        
        for(int i = 1; i <= n; i ++){
            fact *= i;
            fac[i] = fact;
            list.add(i);
        }
        
        StringBuilder sb = new StringBuilder();
        // coz start from 0
        k --;
        
        for(int i = 1; i <= n; i ++){
            int index = k / fac[n - i];
            sb.append(list.get(index));
            list.remove(index);
            k = k - fac[n - i] * index;
        }
        
        return sb.toString();
    }
}