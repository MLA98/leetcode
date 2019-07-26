// Recursive
// Time complexity: O(n);
// Space complexity: O(n); call stack is O(n)
class Solution {
    public int fib(int N) {
        if(N == 0 || N == 1){
            return N;
        }
        
        return fib(N - 1) + fib(N - 2);
    }
}

// Iterative
// Time: O(n)
// Space: O(1)
class Solution {
    public int fib(int N) {
        if(N == 0 || N == 1){
            return N;
        }
        
        int a = 0;
        int b = 1;
        int temp = 0;

        for(int i = 2; i <= N; i ++){
            temp = a + b;
            a = b;
            b = temp;
        }

        return b;
    }
}