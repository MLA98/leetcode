// 脑瘫儿写法 O(32) 
class Solution {
    public boolean isPowerOfTwo(int n) {
        for(int i = 0; i < 32; i ++){
            // 乘法占用时间
            if(n == Math.pow(2, i)){
                return true;
            }
        }
        return false;
    }
}

// 正常人写法 O(32) ????
class Solution {
    public boolean isPowerOfTwo(int n) {
        while(n > 0){
            if(n == 1){
                return true;
            }
            if((n & 1) == 1){
                return false;
            }
            n >>= 1;
        }
        return false;
    }
}

// 高手写法
