class Solution {
    public String getPermutation(int n, int k) {
        // Backtracking is quite not efficient. It exceeds the lmits.
        int[] fac = new int[n];
        List<Integer> num = new LinkedList<Integer>();
        fac[0] = 1;
        for (int i = 1; i < n; i ++) fac[i] = i * fac[i - 1];
        k --;
        for (int j = 1; j <= n; j ++) num.add(j);
        StringBuilder sb = new StringBuilder();
        for (int p = n; p > 0; p --){
            // (1, 2, 3; 1, 3, 2; 2, 1, 3)...... 
            int ans = k / fac[p - 1];
            k = k % fac[p - 1];
            sb.append(num.get(ans));
            num.remove(ans);
        }
        return sb.toString();
    }
}

// This problem is basically copy-paste... I used backtracking technic but it was super slow. This appraoch is really great. 
// I understand the algorithm but I don't know why we have to k -- before the last for loop. The reason might be
// The index starts from 0.

// https://leetcode.com/problems/permutation-sequence/discuss/22508/An-iterative-solution-for-reference
// remembering it is better way.....
