from Array import Array

class MaxHeap:
    def __init__(self, arr =None,capacity = None):
        if isinstance(arr, Array):
            self._data = arr
            for i in range(self._parent(arr.get_size() - 1), -1, -1):
                self._sift_down(i)
            return

        if not capacity:
            self._data = Array()
        else:
            self._data = Array(capacity=capacity)

    def size(self):
        return self._data.get_size()

    def is_empty(self):
        return self._data.is_empty()

    def _parent(self, index):
        if index == 0:
            raise ValueError('index-0 doesn\'t have parent.')
        return (index - 1) // 2

    # 都是简答的数组
    def _left_child(self, index):
        return index * 2 + 1
    
    def _right_child(self, index):
        return index * 2 + 2
    
    # 添加到最后的
    def add(self, e):
        self._data.add_last(e)
        self._sift_up(self._data.get_size() - 1)
    

    def _sift_up(self, k):
        while k > 0 and self._data.get(k) > self._data.get(self._parent(k)):
            self._data.swap(k, self._parent(k))
            k = self._parent(k)

    def _sift_down(self,k):
        while self._left_child(k) < self._data.get_size():
            j = self._left_child(k)
            if j + 1 < self._data.get_size() and self._data.get(j + 1) > self._data.get(j):
                j = self._right_child(k)
                if self._data.get(k) > self._data.get(j):
                    break
                self._data.swap(k,j)
                k = j

            
    def find_max(self):
        if self._data.get_size() == 0:
            raise ValueError('Can not find_max when heap is empty.')
        return self._data.get(0)

    def replace(self,e):
        ret = self.find_max()
        self._data.set(0, e)
        self._sift_down(0)
        return ret
    
    def extract_max(self):
        ref = self.find_max()
        self._data.swap(0,self._data.get_size()-1)
        self._data.remove_last()
        self._sift_down(0)
        return ref

    def HeapSort(self,alist):
        MaxHeap(alist)
        sortedList=[self.extract_max() for x in range(self._data.get_size())]
        sortedList.reverse()
        return sortedList



if __name__ == '__main__':
    n = 10
    from time import time

    start_time1 = time()
    max_heap = MaxHeap()
    from random import randint
    for i in range(n):
        max_heap.add(randint(0, 1000))
 
    start_time2 = time()
    arr = Array()
    from random import randint
    for i in range(n):
        num = randint(0, 10)
        arr.add_last(num)
        
    max_heap = MaxHeap(arr)
    print(max_heap.extract_max())

    

