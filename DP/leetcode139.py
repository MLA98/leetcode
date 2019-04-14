

class Solution(object):
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: List[str]
        :rtype: bool
        """
        wordDict = set(wordDict)
        dic = {}
        
        
        def helper(s):
            if s in dic:
                return dic[s]
            if s in wordDict:
                return True
            for i in range(len(s)):
                if s[0 : i + 1] in dic:
                    if dic[s[0 : i + 1]] == True:
                        if helper(s[i + 1 : len(s)]):
                            return True
                else:
                    if s[0 : i + 1] in wordDict:
                        dic[s[0 : i + 1]] = True
                        if helper(s[i + 1 : len(s)]):
                            return True
                    else:
                        dic[s[0 : i + 1]] = False
            return False        
        
        return helper(s)
