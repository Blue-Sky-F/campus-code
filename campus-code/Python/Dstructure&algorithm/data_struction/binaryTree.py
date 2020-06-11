#二叉树的实现
class Node:
    def __init__(self,data):
        self.data = data
        self.left = None
        self.right = None
class BinaryTree:
    def __init__(self):
        self.count = 0
    def createTree(self,root, values, i):
        if(i<len(values)):
            if(values[i]==' '):
                root = None
            else:
                lchild = Node(None)
                rchild = Node(None)
                root.data = values[i]
                self.count +=1
                root.left = self.createTree(lchild,values,self.count)
                self.count +=1
                root.right = self.createTree(rchild,values,self.count)
        return root
    #先序遍历
    def preTravel(self,root):
        if(root!=None):
            print(root.data)
            self.preTravel(root.left)
            self.preTravel(root.right)
    #中序遍历        
    def middTravel(self,root):
        if(root!=None):
            self.middTravel(root.left)
            print(root.data)
            self.middTravel(root.right)
    #后序遍历        
    def posTravel(self,root):
        if(root!=None):
            self.posTravel(root.left)
            self.posTravel(root.right)
            print(root.data)
    #返回最大深度
    def maxLength(self,root):
        if(root!=None):
            left = self.maxLength(root.left)
            right = self.maxLength(root.right)
            return max(left,right)+1
        return 0
    #返回最小深度
    def minLength(self,root):
        if(root!=None):
            left = self.minLength(root.left)
            right = self.minLength(root.right)
            return min(left,right)+1
        return 0

    #搜寻二叉树结点
    def stept1(self,root,node):
        if(root!=None):
            if(root.data==node.data):
                self.tag=1
            else:
                self.stept1(root.left,node)
                self.stept1(root.right,node)
        if(self.tag==1):
            return True
        return False
    def hasNode(self,root,node):
        self.tag = 0
        return self.stept1(root,node)

    #计算某一结点出现次数
    def stept2(self,root,node):
        if(root!=None):
            if(root.data==node.data):
                self.tag+=1
            self.stept2(root.left,node)
            self.stept2(root.right,node)
    def appearTimes(self,root,node):
        self.tag = 0
        self.stept2(root,node)
        return self.tag

    #返回二叉树叶子结点
    def stept3(self,root):
        if(root!=None):
            if(root.left==None and root.right==None):
                self.leaves.append(root.data)
            self.stept3(root.left)
            self.stept3(root.right)
    def findLeaves(self,root):
        self.leaves = []
        self.stept3(root)
        return self.leaves
                    



tree = BinaryTree()
root = Node(None)
values = ['a','b','e',' ',' ','f',' ', ' ','c','g',' ',' ','h',' ','i',' ',' ']
tree.createTree(root, values, 0)
node = Node('a')
print(tree.hasNode(root,node))
print(tree.appearTimes(root,node))
leaves = tree.findLeaves(root)
for i in leaves:
    print(i)




        
	

