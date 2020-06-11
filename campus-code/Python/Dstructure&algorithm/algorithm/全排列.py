
def swap(i,j,data):
    tem = data[i]
    data[i] = data[j]
    data[j] = tem

def fun(data,left,right):
    if(left==right):
        print(data)
    else:
        for i in range(left,len(data)):
            swap(left,i,data)
            fun(data,left+1,right)
            swap(i,left,data)
def allOrder(data):
    return fun(data,0,len(data)-1)
    
if __name__ == "__main__":
    data = [1,2,3,4]
    allOrder(data)

        
    
