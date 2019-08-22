class Solution {
    int sum = 0;
    public int depthSum(List<NestedInteger> nestedList) {
        depthSum(nestedList, 1);
        return sum;
    }
    
    private void depthSum(List<NestedInteger> nestedList, int layer){
        for(NestedInteger list: nestedList){
            if(list.isInteger()){
                sum += list.getInteger() * layer;
            }
            else{
                depthSum(list.getList(), layer + 1);
            }
        }
    }
}