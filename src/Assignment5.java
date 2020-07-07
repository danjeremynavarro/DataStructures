/**
 * Double Linked List that has a method reverse that reverses the order of the list. Indexes start at 1
 * @author Dan Navarro
 * @title Assignment 1 question 5
 * @date June 6, 2020
 */
class DLinkedListReverse<T>{
    /**
     * A double linked list with method reverse() that reverses the list. Indexes start at 1
     */

    // Tracks size
    int size = 0;

    // Dummy node
    Node dummy = new Node(null);

    class Node{
        // Simple Double Link List node with fields next and prev
        private T data;
        Node next;
        Node prev;

        Node(T payload){
            data = payload;
        }

        public T getData(){
            return data;
        }
    }

    public void add(int i, T x){
        /**
         * Adds a node at given index i
         * @param i - location to add node
         * @param x - data for node
         */
        Node currentNode = new Node(x);
        if (size == 0){
            currentNode.prev = dummy;
            currentNode.next = dummy;
            dummy.next = currentNode;
        } else {
            Node tailNode = getNode(i);
            currentNode.prev = tailNode;
            currentNode.next = tailNode.next;
            tailNode.next = currentNode;
        }
        size++;
        dummy.prev = getNode(size);
    }

    public Node remove(int i){
        /**
         * Removes the node at index x and returns the removed node
         * @param x - index of element to remove
         * @return Node
         */
        Node popNode = getNode(i);
        popNode.next.prev = popNode.prev;
        popNode.prev.next = popNode.next;
        size --;
        return popNode;
    }

    public void reverse(){
        /**
         * Reverses the list by creating a newdummy and iterating through the existing list on reverse.
         * it will then reassign the newly created dummy to the existing dummy.
         */

        // A new Dummy that will link the reversed list
        Node newDummy = new Node(null);
        newDummy.next = newDummy;
        newDummy.prev = newDummy;

        // Keeps track of the last node in the list. This is so that we can link the tail to the dummy
        Node tailNode = newDummy;
        for (int i = size; i != 0; i--){
            Node currentNode = getNode(i);
            if (i == size){
                currentNode.prev = newDummy;
                currentNode.next = newDummy;
                newDummy.next = currentNode;
            } else {
                tailNode.next = currentNode;
                currentNode.prev = tailNode;
            }
            tailNode = currentNode;
        }

        // Set next of tail node to dummy
        tailNode.next = newDummy;

        // Set prev of dummy to tail node
        newDummy.prev = tailNode;

        // Overwrite current dummy with newDummy
        dummy = newDummy;
    }

    public Node getNode(int x){
        /**
         * returns node at given x index. Index starts at 1
         * @param x - index of node. Index starts at 1
         */
        if (size < x){
            /** If given index is more than the size. return node at the end of the list. Should raise out of bounds error
             * here but for simplicity the user input is corrected instead.
             */
            x = size;
        }

        Node currentNode = dummy.next;
        for (int i = 1; i < x; i++){
            currentNode = currentNode.next;
        }
        return currentNode;
    }
}

class Assignment5 {
    public static void main(String[] args){
        DLinkedListReverse<Integer> test = new DLinkedListReverse<>();
        test.add(1, 1);
        test.add(2, 2);
        test.add(3, 3);

        test.reverse();

        System.out.println(test.getNode(1).getData());
        System.out.println(test.getNode(2).getData());
        System.out.println(test.getNode(3).getData());
    }
}
