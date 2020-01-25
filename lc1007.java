class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        Map<Integer, Integer> countMap = new HashMap();
        int length = A.length;
        int minARotation = -1;
        int minBRotation = -1;
        
        for(int a : A) {
            int count = countMap.getOrDefault(a, 0) + 1;
            countMap.put(a, count);
            
            if(count >= (A.length + 1) / 2) {
                minARotation = rotation(A, B, a);
                break;
            }
        }
        
        countMap = new HashMap();
        for(int b : B) {
            int count = countMap.getOrDefault(b, 0) + 1;
            countMap.put(b, count);
            
            if(count >= (B.length + 1) / 2) {
                minBRotation = rotation(B, A, b);
                break;
            }
        }
        
        
        if(minBRotation == -1 && minARotation == -1) {
            return -1;
        }
        else if(minBRotation == -1) {
            return minARotation;
        }
        else if(minARotation == -1) {
            return minBRotation;
        }
        
        return Math.min(minBRotation, minARotation);
    }
    
    private int rotation(int[] mainArr, int[] subArr, int candidate) {
        int ans = 0;
        for(int i = 0; i < mainArr.length; i ++) {
            if(mainArr[i] == candidate) {
                continue;
            }
            else if(subArr[i] == candidate){
                ans ++;
            }
            else {
                return -1;
            }
        }
        
        return ans;
    }
}

class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        int candA = A[0];
        int candB = B[0];
        
        int checkA = check(A, B, candA);
        int checkB = check(A, B, candB);
        
        if(checkA == -1 && checkB == -1) {
            return -1;
        }
        else if(checkA == -1) {
            return checkB;
        }
        else if(checkB == -1) {
            return checkA;
        }
        
        return Math.min(checkA, checkB);
    }
    
    private int check(int[] A, int[] B, int num) {
        int AR = 0;
        int BR = 0;
        
        for(int i = 0; i < A.length; i ++) {
            if(A[i] != num && B[i] != num) {
                return -1;
            }
            else if(A[i] != num) {
                AR ++;
            }
            else if(B[i] != num) {
                BR ++;
            }
        }
        
        return Math.min(AR, BR);
    }
}
