from turtle import*
from random import*
from time import sleep

class Sort:
      def __init__(self):
            pass
      def select(data):  #选择排序；
            for i in range(len(data)-1):
                  min = i
                  for j in range(i+1,len(data)):
                        if(data[min]>data[j]):
                              min = j
                  temp = data[i]
                  data[i] = data[min]
                  data[min] = temp
                  Sort.paintArray(data)
      def pop(data): #冒泡排序（假冒泡）
            for i in range(len(data)-1):
                  j=len(data)-2
                  while(j>i-1):
                        if(data[j]>data[j+1]):
                              temp = data[j]
                              data[j] = data[j+1]
                              data[j+1] = temp
                              Sort.paintArray(data)
                        j = j-1         
      def insert_sort(data):#直接插入排序
            for i in range(1,len(data)):
                  for j in range(i):
                        if(data[i]>=data[j]):
                              continue
                  #前面有比新来的数小，需要插入
                        n = i-1
                        temp = data[i]
                        while(n>=j):#后面的数后移一位
                              data[n+1] = data[n]
                              n = n-1
                        data[j] = temp
                  Sort.paintArray(data)                           
      def merge_sort(data):#归并排序
            temp = []
            for i in range(len(data)):
                  temp.append(0)
            Sort.mergeSort(data,temp,0,len(data)-1)
      def mergeSort(data,tempArray,first,last):#归并排序
            if(first<last):
                  mid = int ((first+last)/2)
                  Sort.mergeSort(data,tempArray,first,mid)
                  Sort.mergeSort(data,tempArray,mid+1,last)
                  Sort.merge(data,tempArray,first,mid,last)
      def merge(data,tempArray,first,mid,last):
            beginHalf1 = first
            endHalf1 = mid
            beginHalf2 = mid+1
            endHalf2 = last
            index = 0
            while(beginHalf1<=endHalf1 and beginHalf2<=endHalf2 ):
                  if(data[beginHalf1]<=data[beginHalf2]):
                        tempArray[index] = data[beginHalf1]
                        beginHalf1 = beginHalf1+1
                  else:
                        tempArray[index] = data[beginHalf2]
                        beginHalf2 = beginHalf2+1
                  index = index+1
            while(beginHalf1<=endHalf1):
                  tempArray[index] = data[beginHalf1]
                  beginHalf1 = beginHalf1+1
                  index = index+1
            while(beginHalf2<=endHalf2):
                  tempArray[index] = data[beginHalf2]
                  beginHalf2 = beginHalf2+1
                  index = index+1
            for i in range(index):
                  data[first] = tempArray[i]
                  first = first+1
            Sort.paintArray(data)
      def quick_sort(data):#快速排序
            lenth = len(data)-1
            Pre_quick_sort(data,0,lenth)       
      def Pre_quick_sort(data,l,r):
            if(l<r):
                  i = l
                  j = r
                  x = data[i]
                  while(i<j):
                        while(i<j and data[j]>x):
                              j = j-1
                        if(i<j):
                              data[i] = data[j]
                              i = i+1       
                        while(i<j and data[i]<x):
                              i = i+1
                        if(i<j):
                              data[j] = data[i]
                              j = j-1
                  data[i] = x
                  Sort.paintArray(data)

                  Pre_quick_sort(data,l,i-1)
                  Pre_quick_sort(data,i+1,r)
      def shellSort(data):#希尔排序
            gap = int(len(data)/2)
            while(gap>=1):#缩小增量
                  for i in range(gap,len(data)):
                        temp = data[i]
                        j = i - gap
                        while(j>=0 and data[j]>temp):
                              data[j+gap] = data[j]
                              j = j-gap
                        data[j+gap] = temp
                        Sort.paintArray(data)
                  gap = int(gap/2)
      def paintArray(data):#打印数组
            setup(800, 600, 0, 0)
            clear()
            hideturtle()
            penup()
            tracer(False)       
            goto(-300,0)
            pendown()
            pensize(6)
            for i in range(len(data)):
                  left(90)
                  forward(data[i])
                  back(data[i])
                  right(90)
                  forward(15)
            tracer(True)
            sleep(0.5)
      def travel(data):#递归遍历数组
            Sort.recursion(data,0,len(data)-1)
      def recursion(data, first, last):
            if(first==last):
                  print(data[first])
            else:
                  mid = int((first+last)/2)
                  Sort.recursion(data,first,mid)
                  Sort.recursion(data,mid+1,last)




if __name__== "__main__":
      data=[]
      for i in range(20):
            data.append((20-i)*10)
      #Sort.select(data)
      #Sort.pop(data)
      Sort.insert_sort(data)
      #Sort.quick_sort(data)
      #Sort.shellSort(data)
      #Sort.travel(data)
      #Sort.merge_sort(data)
      mainloop()
      
      
      
                        
                  

            

                  
      
