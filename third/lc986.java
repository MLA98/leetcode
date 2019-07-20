// Sb force.
class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<Integer> ansList = new ArrayList<>();
        for(int[] a: A){
            for(int[] b: B){
                if(!(a[1] < b[0] || b[1] < a[0])){
                    ansList.add(Math.max(a[0], b[0]));
                    ansList.add(Math.min(a[1], b[1]));
                }
            }
        }
        int[][] ans = new int[ansList.size() / 2][2];
        int j = 0;
        for(int i = 0; i < ans.length; i ++){
            ans[i][0] = ansList.get(j);
            ans[i][1] = ansList.get(j + 1);
            j += 2;
        }
        return ans;
    }
}

// O(m + n) Utilize the pattern that intervals in A or B could move on each iteration.
// The pattern is truly clear if you illustrate them in pictures.
class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<Integer> ansList = new ArrayList<>();
        int i, j;
        i = j = 0;
        while(i < A.length && j < B.length){
            if(!(A[i][1] < B[j][0] || B[j][1] < A[i][0])){
                ansList.add(Math.max(A[i][0], B[j][0]));
                ansList.add(Math.min(A[i][1], B[j][1]));
            }
            if(B[j][1] > A[i][1]){
                i ++;
            }
            else{
                j ++;
            }
        }

        int[][] ans = new int[ansList.size() / 2][2];
        int k = 0;
        for(int n = 0; n < ans.length; n ++){
            ans[n][0] = ansList.get(k);
            ans[n][1] = ansList.get(k + 1);
            k += 2;
        }
        return ans;
    }
}