class Solution(object):
    def generateParenthesis(self, n):
        ans = []
        def helper(curr, right, left):
            if (right == n): # when the right bracket reaches n, append the curr
                ans.append(curr)
            
            if (right < left): # when there are opening bracket, we could add right bracket that could close
                curr1 = curr + ')' 
                helper(curr1, right + 1, left)
            
            if (left < n): # when the left bracket does not reach n, we could open it(add it)
                curr2 = curr + '('
                helper(curr2, right, left + 1)
                
        helper('', 0, 0) # start the tree
        return ans
    
# basically it is a recursion tree that size is 
