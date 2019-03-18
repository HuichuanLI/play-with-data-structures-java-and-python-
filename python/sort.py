from random import randint
import timeit

max=10000
list=[randint(0,max) for x in range(max)]

alist=list[:]
blist=list[:]
clist=list[:]
dlist=list[:]





def bubbleSort(alist):
    exchange=False
    for i in range(len(alist)-1,0,-1):
        for j in range(i):
            if alist[j]>alist[j+1]:
                alist[j],alist[j+1]=alist[j+1],alist[j]
                exchange=True
        if not exchange:
            break
    return alist

def selectionSort(alist):
    for i in range(0,len(alist)-1,1):
        key = i
        for j in range(i,len(alist),1):
            if(alist[j]<alist[key]):
                key = j
        alist[i],alist[key] = alist[key],alist[i]
    return alist

def insertionSort(alist):
    for i in range(1,len(alist),1):
        key = alist[i]
        for j in range(i-1,-1,-1):
            if(key < alist[j]):
                alist[j],alist[j+1]=alist[j+1],alist[j]
    return alist

        

def shellSort(alist):
    gap = len(alist)//2
    while gap>=1:
        for i in range(gap,len(alist),1):
            key = alist[i]
            j= i-gap
            while j>=0:
                if(key<alist[j]):
                    alist[j],alist[j+gap]=alist[j+gap],alist[j]
                j= j-gap
        gap = gap//2 
    return alist


t1=timeit.Timer('bubbleSort(alist)','from __main__ import bubbleSort,alist')
print('短路冒泡排序: %s s' %t1.timeit(number=1))



t2=timeit.Timer('selectionSort(blist)','from __main__ import selectionSort,blist')
print('选择排序: %s s' %t2.timeit(number=1))




t3=timeit.Timer('insertionSort(clist)','from __main__ import insertionSort,clist')
print('插入排序: %s s' %t3.timeit(number=1))


t4=timeit.Timer('shellSort(dlist)','from __main__ import shellSort,dlist')
print('希尔排序: %s s' %t3.timeit(number=1))
