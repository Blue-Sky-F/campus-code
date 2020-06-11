#用Python实现一个循环队列
class Queue:
    def __init__(self,size):
        self.data = []
        for i in range(size):
            self.data.append(None)
        self.first = 0
        self.last = 0
        self.size = size
    #入队
    def add(self,data):
        if((self.first-self.last)%self.size==1):
            return "full"
        else:
            self.data[self.last] = data
            self.last = (self.last+1)%self.size
    #出队
    def out(self):
        if(self.last == self.first):
            return "empty"
        else:
            data = self.data[self.first]
            self.first = (self.first+1)%self.size
            return data
             

queue = Queue(10)
for i in range(10):
    queue.add(i)
for i in range(10):
    print(queue.out())
