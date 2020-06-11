class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        longest = ''
        for i in range(len(s)):
            palindromic = self.getPalindromic(s[i:])
            if(len(palindromic)>len(longest)):
                longest = palindromic
        return longest
    def getPalindromic(self,s):
        palindromic = ''
        for i in range(1,len(s)+1):
            subString = s[0:i]
            temp = list(subString)
            temp1 = []
            for i in temp:
                temp1.append(i)
            temp.reverse()
            if(temp==temp1 and len(subString)>len(palindromic)):
                palindromic = subString
        return palindromic
solution = Solution()
string1 = 'assasdfsd'
string2 = 'a'
palindromic = solution.longestPalindrome(string1)
print(palindromic)