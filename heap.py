#MaxHeap
class MaxHeap(object):
    def __init__(self):
        self.queue = []

    #get value from heap
    def get_max(self):
        last_index = self.get_length()
        if last_index < 0:
            return -1
        self.swap(0, last_index)
        max = self.queue.pop()
        self.heapify(0)
        return max

    #insert value to heap
    def insert(self, value):
        self.queue.append(value)
        last_index = self.get_length()
        while 0 <= last_index:
            parent_index = self.get_parent(last_index)
            if parent_index >= 0 and self.queue[parent_index] < self.queue[last_index]:
                self.swap(last_index, parent_index)
                last_index = parent_index
            else:
                break

    #reorganzation
    def heapify(self, index):
        left_index = self.get_left(index)
        right_index = self.get_right(index)
        max_index = index

        if left_index <= self.get_length() and self.queue[max_index] < self.queue[left_index]:
            max_index = left_index
        if right_index <= self.get_length() and self.queue[max_index] < self.queue[right_index]:
            max_index = right_index
        
        if max_index != index:
            self.swap(index, max_index)
            self.heapify(max_index)

    #swap node
    def swap(self, indexA, indexB):
        self.queue[indexA], self.queue[indexB] = self.queue[indexB], self.queue[indexA]

    #get last index
    def get_length(self):
        return len(self.queue) - 1

    #get parent_node
    def get_parent(self, index):
        return (index - 1) // 2

    #get left_node
    def get_left(self, index):
        return index * 2 + 1

    #get right_node
    def get_right(self, index):
        return index * 2 + 2

    #print
    def print_heap(self):
        print(self.queue)


#MinHeap
class MinHeap(object):
    def __init__(self):
        self.queue = []

    #get value from heap
    def get_min(self):
        last_index = self.get_length()
        if last_index < 0:
            return -1
        self.swap(0, last_index)
        min = self.queue.pop()
        self.heapify(0)
        return min

    #insert value to heap
    def insert(self, value):
        self.queue.append(value)
        last_index = self.get_length()
        while 0 <= last_index:
            parent_index = self.get_parent(last_index)
            if parent_index >= 0 and self.queue[parent_index] > self.queue[last_index]:
                self.swap(last_index, parent_index)
                last_index = parent_index
            else:
                break

    #reorganzation
    def heapify(self, index):
        left_index = self.get_left(index)
        right_index = self.get_right(index)
        min_index = index

        if left_index <= self.get_length() and self.queue[min_index] > self.queue[left_index]:
            min_index = left_index
        if right_index <= self.get_length() and self.queue[min_index] > self.queue[right_index]:
            min_index = right_index
        
        if min_index != index:
            self.swap(index, min_index)
            self.heapify(min_index)

    #swap node
    def swap(self, indexA, indexB):
        self.queue[indexA], self.queue[indexB] = self.queue[indexB], self.queue[indexA]

    #get last index
    def get_length(self):
        return len(self.queue) - 1

    #get parent_node
    def get_parent(self, index):
        return (index - 1) // 2

    #get left_node
    def get_left(self, index):
        return index * 2 + 1

    #get right_node
    def get_right(self, index):
        return index * 2 + 2

    #print
    def print_heap(self):
        print(self.queue)
    

#list -> heap_list
def list_to_max_heap(listA):
    temp = MaxHeap()
    for i in listA:
        temp.insert(i)
    temp.print_heap()
    return temp

def list_to_min_heap(listA):
    temp = MinHeap()
    for i in listA:
        temp.insert(i)
    temp.print_heap()
    return temp

def main():
    print("구동확인")
    lista = [3,5,8,11,26,47,68]
    mh = list_to_min_heap(lista)
    print(mh.get_min())
    mh.print_heap()

if __name__ == "__main__":
    main()