class linkedlist:
    class _Node:
        def __init__(self,e =None,node = None):
            self.e = e
            self.next = node

        def __str__(self):
            return str(self.e)

        def __repr__(self):
            return self.__str__()

    def __init__(self):
        self.head = self._Node()
        self._size = 0

    def get_size(self):
        return self._size
    
    def isEmpty(self):
        return self._size == 0
    
    def getter(self,index):
        if index <0 or index > self._size :
            raise ValueError('Get failed. Illegal index.')
        cur = self.head.next
        for i in range(index):
            cur = cur.next
        return cur.e
    
    def get_first(self):
        return self.getter(0)

    def get_last(self):
        return self.getter(self._size - 1)  

    def add(self,index,e):
        if index <0 or index > self._size :
            raise ValueError('Get failed. Illegal index.')
        cur = self.head
        for i in range(index):
            cur = cur.next
        cur.next = self._Node(e,cur.next)
        self._size = self._size +1 
    
    def add_first(self, e):
        self.add(0, e)

    def add_last(self, e):
        self.add(self._size, e)

     
        


    




