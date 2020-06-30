/**
 * @author Dan Jeremy Navarro
 * @title Assignment 1 question 1a
 * Priority Queue implementation using Linked List
 */

interface PriorityQueue<T> {
    // The add method on a priority Queue takes an element and adds it to the queue.
    void add(T x);

    // The deleteMin method returns the element that is next in queue and removes it from the queue
    T deleteMin() throws IsEmptyException;

    // size variable is used to determine current size of queue.
    int size();
}

class IsEmptyException extends Exception{
    /**
     * Exception when list is empty
     */
    IsEmptyException(){
        super("List is empty");
    }
}

class LinkedList<T> implements PriorityQueue<T> {

    // Keeps track of first element in queue
    Node head;

    // Keeps track of last element in queue
    Node tail;

    // Keeps track of list size
    private int listSize = 0;


    class Node{
        /**
         *  A basic node of a linked list. Contains data of node and a pointer to the next node
         */

        // Contains data of a node
        private T data;

        // Contains a pointer to the next node
        Node next;

        Node(T x){
            data = x;
        }


        public T getData(){
            /**
             * Returns data of node
             * @return data
             */
            return data;
        }
    }

    @Override
    public void add(T payload){
        /**
         * The add method receives a payload and adds it to the tail of the list.
         * This method assigns the head, tail and size of current Linked List object
         *
         * @param payload - element to add to the list
         */
        Node currentNode = new Node(payload);
        if ( listSize == 0){
            head = currentNode;
        }
        if (listSize != 0){
            tail.next = currentNode;
        }
        tail = currentNode;
        listSize++;
    }

    @Override
    public T deleteMin() throws IsEmptyException{
        /**
         * Returns and removes head. Also moves the head of the list to head.next
         * @return head of list
         * @throws is empty exception
         */
        if (listSize == 0){
            throw new IsEmptyException();
        }
        Node a = head;
        head = head.next;
        listSize--;
        return a.getData();
    }

    public T getMin(){
        return head.getData();
    }

    @Override
    public int size(){
        /**
         * Returns current size of list.
         * @return size of list
         */
        return listSize;
    }
}

class Assignment1a {
    // Answer to Assignment 1 question 1a
    public static void main(String[] args) throws IsEmptyException {
        // Test Case using initial queue of [1290, 2127877, 12457, 5454]
        LinkedList<Integer> testList = new LinkedList<>();
        testList.add(1290);
        testList.add(2127877);
        testList.add(12457);
        testList.add(5454);
        // Current queue after operations above [1290, 2127877, 12457, 5454]

        System.out.println(testList.deleteMin() + " Return and removed first in queue");
        // Current queue after operation above [2127877, 12457, 5454]

        System.out.println(testList.size() + " Current size of queue");
        System.out.println(testList.getMin() + " Current head of queue");
        System.out.println(testList.deleteMin() + " Return and removed first in queue");
        // Current queue after operation above [12457, 5454]

        System.out.println(testList.size() + " Current size of queue");
        System.out.println(testList.getMin() + " Current head of queue");
    }
}
