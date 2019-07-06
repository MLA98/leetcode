class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        // WDNMD 真tm简单
        int areaA = (C - A) * (D - B);
        int areaB = (G - E) * (H - F);
        
        int left = Math.max(E, A);
        int right = Math.min(C, G);
        int top = Math.min(D, H);
        int bot = Math.max(F, B);
        
        int overlapped = 0;
        if(right > left && top > bot){
            overlapped = (right - left) * (top - bot);
        }
        return areaA + areaB - overlapped;
    }
}