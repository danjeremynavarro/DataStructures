/**
 * Auto-resizing Stack(LIFO) implementation using two Queues(FIFO).
 * @author Dan Navarro
 * @title Assignment 1 question 1b answer
 * @date June 6, 2020
 */

import java.lang.reflect.Array;

class Stack<T>{
    /**
     * Implements Last in First out. Automatically resize as the stack gets full.
     */

    //queue1 is used when pushing into the stack
    private Queue<T> queue1;

    //queue2 is used when popping from the stack
    private Queue<T> queue2;

    //Stores the type of the stack
    private Class<T> dataType;

    //Stores max amount of elements in the stack
    private int maxSize;

    //Stores current amount of elements in the stack
    private int currentSize = 0;

    /**
     * @param type - type of the stack
     * @size size - initial size of the stack
     */
    Stack(Class<T> type, int size){
        dataType = type;
        queue1 = new Queue<>(type, size);
        queue2 = new Queue<>(type, size);
        maxSize = size;
    }

    /**
     *  The push implementation has a worst case runtime of O(1)
     * @param data - data to push
     */
    public void push (T data) {
        if (shouldResize()) {
            resize();
        }
        queue1.push(data);
        currentSize++;
    }

    /**
     *  The pop implementation has a worst case runtime of O(n + 1) if data are pushed
     *  to n times without popping the stack.
     * @return element from stack
     */
    public T pop(){
        while(!queue1.isEmpty()){
            T data = queue1.pop();
            queue2.push(data);
        }
        T payload;
        payload = queue2.pop();
        return payload;
    }

     //Resize the queues in the stack
    private void resize(){
        Queue<T> newQueue1 = new Queue<>(dataType, maxSize * 2);
        Queue<T> newQueue2 = new Queue<>(dataType, maxSize * 2);

        while(!queue1.isEmpty()){
            newQueue1.push(queue1.pop());
        }
        while(!queue2.isEmpty()){
            newQueue1.push(queue1.pop());
        }

        queue1 = newQueue1;
        queue2 = newQueue2;
    }

    private boolean shouldResize(){
        return maxSize == currentSize;
    }
}

class Queue<T>{
    /**
     * Implements First in First out method
     */

    // Tracks the type of the array
    private Class<T> dataType;

    // Contains the data in the queue
    private T[] container;

    // Keeps track of the max amount of elements in the queue
    private int maxSize;

    // Keeps track of number of elements in queue
    private int currentSize = 0;

    // Keeps track of the index where data is taken from
    private int head;

    // Keeps tracks of the index where data is added to
    private int tail;

    Queue(Class<T> type, int size){
        dataType = type;
        container = newArray(size);
    }

    public boolean isEmpty(){
        return currentSize == 0;
    }

    /**
     * Add to queue
     * @param data - element to add
     */
    public void push(T data){
        if (currentSize == 0){
            head = 0;
            tail = 0;
        }
        container[tail] = data;
        currentSize++;
        tail++;
    }

    /**
     * Remove from queue
     * @return element from queue
     */
    public T pop() {
        T payload = container[head];
        currentSize--;
        head++;
        return payload;
    }

    // A way to get around Java's weakness with generics.
    // https://stackoverflow.com/questions/529085/how-to-create-a-generic-array-in-java
    @SuppressWarnings("unchecked")
    private T[] newArray(int size){
        return (T[]) Array.newInstance(dataType, size);
    }
}

class Assignment1b {
    public static void main(String[] args){
        Stack<Integer> test = new Stack<>(Integer.class, 10);

        test.push(1);
        test.push(2);
        test.push(3);
        test.push(4);
        test.push(5);
        test.push(6);
        test.push(7);
        test.push(8);
        test.push(9);
        test.push(10);
        test.push(11);
        test.push(12);
        test.push(13);
        test.push(14);
        test.push(15);

        System.out.println(test.pop());
        System.out.println(test.pop());
        System.out.println(test.pop());
        System.out.println(test.pop());
        System.out.println(test.pop());
    }
}
