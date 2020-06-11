class Solution(object):
    '''
    该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
    在任何情况下，若函数不能进行有效的转换时，请返回 0
    '''
    def myAtoi(self, string):
        """
        :type str: str
        :rtype: int
        """
        result = ''
        index = self.index_of_start(string)
        if(index==-1):
            return 0
        if(string[index]=='-'):
            for i in range(index+1,len(string)):
                if(self.isNumber(string[i])):
                    result = result+string[i]
                else:
                    break
            return int('-'+result)
        else:
            for i in range(index,len(string)):
                if(self.isNumber(string[i])):
                    result = result+string[i]
                else:
                    break
            return int(result)
                
            
    def isNumber(self, ch):
        data = ['0','1','2','3','4','5','6','7','8','9']
        if(ch in data):
            return True
        return False
    
    def index_of_start(self,string):
        for i in range(len(string)):
            if(string[i]==' '):
                continue
            try:
                if (self.isNumber(string[i]) or (string[i]=='-' and self.isNumber(string[i+1])) ):
                    return i
            except:
                return -1
            else:
                return -1
        return -1
string1 = '   344534535sdfs'
string2 = '323dsfsd'
string3 = 'sfsf3434'
solution = Solution()
number = solution.myAtoi(string3)
print(number)