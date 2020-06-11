
class Stack:
    def __init__(self):
        self.data = []
        self.point = 0

    def push(self,data):
        self.data.append(data)
        self.point +=1

    def pop(self):
        if(self.point==0):
            return None
        else:
            self.point -=1
            return self.data[self.point]
class Node:
    def __init__(self,name,year):
        self.name = name
        self.year = year
    def show(self):
        print('My name is:'+self.name+'\t'+'My age is:'+str(self.year))
        
stack = Stack()
stack.push(Node('Eason',20))
for i in range(5):
    stack.push(i)
for i in range(5):
    print(stack.pop())
node = stack.pop()
print(node.name)