from turtle import*
import math

#图的实现
class Circle:
    def __init__(self,pos,radius,number):
        self.pos = pos
        self.radius = radius
        self.num = number
    def drawCircle(self):
        setpos(self.pos)
        pendown()
        circle(self.radius)
        write(self.num,font=30)
        penup()
    def drawLine(self,pos1,pos2):
        setpos(pos1)
        pendown()
        setpos(pos2)
        penup()  
class Graph:
    def __init__(self,maxVertexNum):
        self.vexs = []
        self.edges = []
        self.n = 0
        self.e = 0
        for i in range(maxVertexNum):
            self.vexs.append(0)
            self.edges.append([])
        for i in range(maxVertexNum):
            for j in range(maxVertexNum):
                self.edges[i].append(0)
    def createGraph(self,vexs,edges):
        self.n = len(vexs)
        self.e = len(edges)
        for i in range(self.n):
            index = vexs[i]
            self.vexs[index] = 1
        for i in range(self.e):
            x = edges[i][0]
            y = edges[i][1]
            self.edges[x][y] = 1
    def travel(self):
        print("顶点有:")
        for i in range(len(self.vexs)):
            if(self.vexs[i]==1):
                print(i)
        print("边有:")
        for i in range(len(self.edges)):
            for j in range(len(self.edges)):
                if(self.edges[i][j]==1):
                    print('('+str(i)+','+str(j)+')')
    #Turtle图形化                
    def createGraphByTurtle(self):
        positions = self.initpos(self.n)
        circles = []

        for i in range(self.n):
            circle = Circle(positions[i],30,i)
            circle.drawCircle()
            circles.append(circle)
        for i in range(self.n):
            if(i<self.n-1):
                circle.drawLine(positions[i],positions[i+1])
    
    def initpos(self,number):
        positions = []
        n = number
        x1 = 200/n
        y1 = 300/n
        for i in range(n):
            p1 = i*x1
            p2 = i*y1
            positions.append((p1,p2))
        return positions

        


        
    

graph = Graph(12)
vexs = [1,2,3,4,6,7,8,9,10,11]
edges = [(1,4),(2,4),(3,5),(4,5),(5,6),(5,8),(7,8),(8,9),(8,11),(10,11)]
graph.createGraph(vexs,edges)
graph.travel()
graph.createGraphByTurtle()




        
