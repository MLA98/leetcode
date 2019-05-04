class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] minCost = new int[triangle.size() + 1][triangle.size() + 1];
        for (int i = triangle.size() - 1; i >= 0; i --){
            int[] tempList = new int[triangle.size()];
            for (int j = 0; j < triangle.get(i).size(); j ++){
                tempList[j] = Math.min((triangle.get(i).get(j) + minCost[i + 1][j]), (triangle.get(i).get(j) + minCost[i + 1][j + 1]));
            }
            minCost[i] = tempList;
        }
        return minCost[0][0];
        
    }
}

// Should be easy. But java adds the complexity.