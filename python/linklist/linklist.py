class LinkedList:
    class _Node:
        def __init__(self, e=None, node_next=None):
            self.e = e
            self.next = node_next
        def __str__(self):
            return str(self.e)
        def __repr__(self):
            return self.__str__()
    def __init__(self):
        self._dummy_head = self._Node()
        self._size = 0

    def get_size(self):
        return self._size
    def is_empty(self):
        return self._size == 0
    def add_first(self, e):
        self.add(0, e)
    def add_last(self, e):
        self.add(self._size, e)
    def add(self,index,e):
        if index < 0 or index > self._size:
            raise ValueError('Add failed. Illegal index.')
        prev = self._dummy_head
        for i in range(index):
            prev = prev.next
        node = self._Node(e)
        node.next = prev.next
        prev.next = node
        self._size += 1
        
    def __str__(self):
        curr = self._dummy_head.next
        data = []
        while curr:
            data.append(str(curr.e))
            curr = curr.next
        return '<LinkedList>: (Head) ' + \
            ' -> '.join(data) + ' (Tail)'
    
    def getter(self,index):
        if index < 0 or index > self._size:
            raise ValueError('Add failed. Illegal index.')
        curr = self._dummy_head.next
        for i in range(index):
            curr = curr.next
        return curr.e

    def setter(self,index,e):
        if index < 0 or index > self._size:
            raise ValueError('Add failed. Illegal index.')
        curr = self._dummy_head.next
        for i in range(index):
            curr = curr.next
        curr.e = e
    
    def contains(self, e):
        curr = self._dummy_head.next
        while curr:
            if curr.e == e:
                return True
            curr = curr.next
        return False
    
    def remove(self, index):
        if index < 0 or index >= self._size:
            raise ValueError('Remove failed. Illegal index.')
        prev = self._dummy_head
        for i in range(index):
           prev = prev.next
        node_return = prev.next
        prev.next= node_return.next
        node_return.next= None
        self._size -= 1 
        return node_return.e
    
    def remove_first(self):
        return self.remove(0)

    def remove_last(self):
        return self.remove(self._size - 1)

    def get_first(self):
        return self.getter(0)

    def get_last(self):
        return self.getter(self._size - 1)



if __name__ == '__main__':
    linkedlist = LinkedList()
    print(linkedlist.get_size())
    print(linkedlist.is_empty())
    linkedlist.add_first(1)
    linkedlist.add_first(2)
    linkedlist.add_first(4)
    linkedlist.add_first(5)
    print(linkedlist)
    print(linkedlist.get_size())
    print(linkedlist)
    print(linkedlist.getter(3))
    print(linkedlist.get_first())
    print(linkedlist.get_last())


# example of __str__
# example of __repr__
    
class Person(object):
    def __init__(self, name, gender):
        self.name = name
        self.gender = gender

class Student(Person):
    def __init__(self, name, gender, score):
        super(Student, self).__init__(name, gender)
        self.score = score
    def __str__(self):
        return '(Student: %s, %s, %s)' % (self.name, self.gender, self.score)
    __repr__ = __str__
s = Student('Bob', 'male', 88)
print(s)
s