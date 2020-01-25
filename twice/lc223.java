class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int twoRectArea = (D - B) * (C - A) + (G - E) * (H - F);
        
            int top = Math.min(D,H);
            int bot = Math.max(F,B);
            int left = Math.max(E, A);
            int right = Math.min(C, G);
        
        if(top < bot || right < left) {
            return twoRectArea;
        }
            
        return twoRectArea - (top - bot) * (right - left);
    }
}