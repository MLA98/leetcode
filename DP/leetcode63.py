class Solution(object):
    def uniquePathsWithObstacles(self, obstacleGrid):
        """
        :type obstacleGrid: List[List[int]]
        :rtype: int
        """
        if obstacleGrid[0][0] == 1:
            return 0
        

        for i in range(len(obstacleGrid)):
            for j in range(len(obstacleGrid[0])):
                if obstacleGrid[i][j] == 0:
                    obstacleGrid[i][j] = -1
                else:
                    obstacleGrid[i][j] = -2 
        
        def helper(m,n):
            # robot = (-m + 1, n - 1)
            path = 0
         
            if m == 0 and n == 0:
                return 1
            if obstacleGrid[abs(m)][n] == -2:
                return 0
            if obstacleGrid[abs(m)][n] != -1:
                return obstacleGrid[abs(m)][n]
            if m + 1 <= 0:
                path = path + helper(m + 1, n)
            if n - 1 >= 0:
                path = path + helper(m , n - 1)

            obstacleGrid[abs(m)][n] = path
            return path
        
        return helper(-len(obstacleGrid) + 1, len(obstacleGrid[0]) - 1)
