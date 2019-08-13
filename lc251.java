// Not using the iterator of java
// Simply use two pointers
class Vector2D {

    int i, j;
    int[][] v;
    
    public Vector2D(int[][] v) {
        i = j = 0;
        this.v = v;
    }
    
    public int next() {
        if (hasNext()){
            j ++;
            return v[i][j - 1];
        }

        return - 1;
    }
    
    public boolean hasNext() {
        while(i < v.length && j >= v[i].length){
            // 因为有可能有空的subarray，所以需要这样处理
            // 来跳过空的subarray。
            i ++;
            j = 0;
        }
        
        return i < v.length;
    }
}