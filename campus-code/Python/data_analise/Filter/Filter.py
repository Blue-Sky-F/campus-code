import os

#过滤掉词库中的词
class Filter:
    def __init__(self):
        self.keyword = set()
    def parse(self):
        path = os.getcwd()
        with open(path+"\data_analise\Filter\data\敏感词库\色情词库.txt",'r',encoding='utf-8') as f:
            for line in f.readlines():
                self.keyword.add(line.strip())

    def filter(self,mess):
        for word in self.keyword:
            mess = mess.replace(word,"*")
        return mess
    def targeted_filter(self,filter,mess):
        return mess.replace(filter,"*")
        

if __name__ == "__main__":
    filter = Filter()
    filter.parse()
    mess = "我TMD去你妹包二奶的!" 
    print(filter.filter(mess))
    print(filter.targeted_filter("尼玛","我去尼玛的！"))
            
