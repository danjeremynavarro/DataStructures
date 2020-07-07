/**
 * Single Linked List and Double Linked List implementation with a method
 * called switchAdjacent that switches the position of element at a given index
 * with the adjacent element.
 * @author Dan Navarro
 * @title Assignment 1 question 2 a,b
 * @note indexes starts at 1
 * @date June 6, 2020
 */

class SLinkedList<T>{
    /**
     * A single Linked List implementation that implements FIFO. Methods that can be called are
     * push(), pop(), switchAdjacent() and getNode()
     */

    // Tracks the element at the start of the list.
    Node head;

    // Tracks the element at the end of the list
    Node tail;

    // Tracks current size of list
    int size = 0;

    class Node{
        // Data container for the node
        private T data;

        // Pointer to next node
        Node next;

        Node(T payload){
            data = payload;
        }

        public T getData(){
            return data;
        }

    }

    public void push(T x){
        /**
         * Push method for single linked list. Add x to the end of list
         * @param x - data of type T
         */
        Node newNode = new Node(x);

        if (size == 0){
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }

    public T pop(){
        /**
         *  returns current head of list
         */
        Node payload = head;
        head = payload.next;
        size--;
        return payload.getData();
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
        Node payload = head;
        for (int i = 1; i < x; i++){
            payload = payload.next;
        }
        return payload;
    }

    public void switchAdjacent(int x){
        /**
         * A switch adjacent method that switches the element at given index with the position of its adjacent element.
         */
        if (x == 1 || x == 0){
            /** Also checks if given index is 0. Should raise error but for simplicity a simple
             *  user input correction is added instead. If the element that has to be switch is at the start of
             *  the list edit the head of the list.
             */
            Node adjNode = head.next;
            Node adjNodeNext = adjNode.next;
            head.next = adjNodeNext;
            adjNode.next = head;
            head = adjNode;
        } else {
            /**
             * If the index to switch is not the head of the list get the previous node of the node to be switched
             * and update its links.
             */
            Node switchNodePrev = getNode(x);
            Node switchNode = switchNodePrev.next;
            Node adjNode = switchNode.next;
            Node adjNodeNext = adjNode.next;
            switchNodePrev.next = adjNode;
            adjNode.next = switchNode;
            switchNode.next = adjNodeNext;
        }
    }
}

class DLinkedList<T>{
    /**
     * A double linked list implementation
     */

    // The dummy node that links the start and end of the list
    Node dummy = new Node(null);

    // Current size of list
    int size = 0;

    class Node{
        /**
         * A Double linked list node that has fields next and prev that points to the next node and the previous node
         * respectively
         */
        private T data;
        Node next;
        Node prev;

        Node(T x){
            data = x;
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

    public Node remove(int x){
        /**
         * Removes the node at index x and returns the removed node
         * @param x - index of element to remove
         * @return Node
         */
        Node popNode = getNode(x);
        popNode.next.prev = popNode.prev;
        popNode.prev.next = popNode.next;
        size--;
        return popNode;

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

    public void switchAdjacent(int x){
        /**
         * Switches the element at given index x with its adjacent element
         * @param x - index of element to switch
         */

        if (x == 0){
            /** Also checks if given index is 0. Should raise error but for simplicity a simple
             *  user input correction is added instead
             */
            x = 1;
        }

        Node switchNode = getNode(x);
        Node adjNode = switchNode.next;
        switchNode.prev.next = adjNode;
        switchNode.next = adjNode.next;
        adjNode.prev = switchNode.prev;
        adjNode.next = switchNode;
        switchNode.prev = adjNode;
    }
}

class Assignment2 {

    public static void main(String[] args){
        SLinkedList<Integer> test = new SLinkedList<>();
        test.push(1);
        test.push(2);
        test.push(3);
        test.push(4);
        test.push(5);
        test.push(6);

        System.out.println("List is [1,2,3,4,5,6]");
        System.out.println("Index 3 before switch: " + test.getNode(1).getData());
        test.switchAdjacent(0);
        System.out.println("Switch index of 3 with its next element");
        System.out.println("Index 3 after switch: " + test.getNode(3).getData());
        System.out.println(test.pop());
        System.out.println(test.pop());
        System.out.println(test.pop());
        System.out.println(test.pop());
        System.out.println(test.pop());
        System.out.println(test.pop());

        DLinkedList<Integer> test2 = new DLinkedList<>();
        test2.add(1, 1);
        test2.add(2, 2);
        test2.add(3, 3);
        test2.add(4, 4);
        test2.add(5,5);
        test2.add(6, 6);

        System.out.println("List is [1,2,3,4,5,6]");
        System.out.println("Get element at node 2: " + test2.getNode(2).getData());
        System.out.println("Remove element at node 3: " + test2.remove(3).getData());
        System.out.println("List is [1,2,4,5,6]");
        System.out.println("Get new element at node 3: " + test2.getNode(3).getData());
        System.out.println("Get element at node 4: " + test2.getNode(4).getData());
        System.out.println("Switch index 3 and its next element's position");
        test2.switchAdjacent(3);
        System.out.println("List is [1,2,5,4,6]");
        System.out.println("Get element at node 3: " + test2.getNode(3).getData());
        System.out.println("Get element at node 4: " + test2.getNode(4).getData());
        System.out.println("Get element at node 2: " + test2.getNode(2).getData());
        System.out.println("Get element at node 5: " + test2.getNode(5).getData());

    }
}
