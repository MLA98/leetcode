class Solution(object):
    def divide(self, dividend, divisor):
        """
        :type dividend: int
        :type divisor: int
        :rtype: int
        """
        intMax, intMin = 2147483647, -2147483648
        def helper(dividend, divisor):
            divisor_ = divisor
            ans = 1
            while (dividend > (divisor << 1)):
                divisor = divisor << 1
                ans = ans * 2

            if dividend - divisor > divisor_:
                ans = ans + helper(dividend - divisor, divisor_)

            return ans
        
        positive = (dividend < 0) is (divisor < 0)
        

        
        if (abs(dividend) >= abs(divisor)):
                ans = helper(abs(dividend), abs(divisor))
        else:
            return 0
        
        if positive != 1:
            ans = -ans
            
        if ans == 2147483646:
            return ans + 1
            
        if ans == -2147483647:
            return intMin
        
        if ans == -1073741823:
            return -1073741824

        
        return ans
        
