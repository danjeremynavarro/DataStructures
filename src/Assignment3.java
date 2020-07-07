/**
 * Bag is a data structure that implements Uset only that it allows duplicates and
 * it has a method called findAll that will return a Single Link List object.
 * @author Dan Navarro
 * @title Assignment 1 question 3
 * @date June 6, 2020
 */


import java.lang.reflect.Array;

class Bag<T>{
    // Tracks data type
    private Class<T> datatype;

    // Array containg data
    private T[] data;

    // Tracks max Size
    private int maxSize;

    // Tracks amount of non null values in data
    private int nonNullSize = 0;

    Bag(Class<T> clazz, int size){
        /**
         * See above description
         * @param clazz - class object
         * @param size - initial size of array
         */
        datatype = clazz;
        maxSize = size;
        data = newArray(size);
    }

    @SuppressWarnings("unchecked")
    private T[] newArray(int size){
        return (T[]) Array.newInstance(datatype, size);
    }

    public void add(T x){
        /**
         * Adds a data to the array. Will pick the closes index to 0 with a non null
         * value to insert the data to. Will also resize if maxSize == nonNullSize
         * @param x - data to add
         */
        if (maxSize == nonNullSize){
            resize();
        }
        for (int i = 0; i < data.length; i++){
            if (data[i] == null){
                data[i] = x;
                nonNullSize++;
                break;
            }
        }
    }

    public T find(T x){
        /**
         * Finds a match to given param and returns the object otherwise returns null
         * @param x - data to find
         */
        for (int i = 0; i < data.length; i++){
            if (data[i] != null && data[i].equals(x)){
                T payload = data[i];
                return payload;
            }
        }
        return null;
    }

    public BagLinkedList<T> findAll(T x){
        /**
         * Finds all matching value of given param and returns a linked list
         * of all matching value
         * @param x - data to find
         */
        BagLinkedList<T> bagList = new BagLinkedList<>();
        for (int i = 0; i < data.length; i++){
            if (data[i] != null && data[i].equals(x)){
                bagList.push(data[i]);
            }
        }
        return bagList;
    }

    public void remove(T x){
        /**
         * Finds the param in the set and sets it to null.
         * @param x - data to remove
         */
        for (int i = 0; i < data.length; i++){
            if (data[i] != null && data[i].equals(x)){
                data[i] = null;
                nonNullSize--;
            }
        }
    }

    private void resize(){
        T[] newData = newArray(maxSize * 2);
        int counter = 0;
        for (int i = 0; i < data.length; i++){
            if (data[i] != null){
                newData[counter] = data[i];
                counter++;
            }
        }
        data = newData;
        maxSize *= 2;
    }
}

class BagLinkedList<T>{
    /**
     * Single Link List implementation with push() and pop() methods
     */
    private int size = 0;
    private Node head;
    private Node tail;

    class Node{
        private T data;

        Node next;

        Node (T payload){
            data = payload;
        }

        public T getData(){
            return data;
        }
    }

    public void push(T x){
        Node newNode = new Node(x);

        if (size == 0){
            head = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }

        tail = newNode;
        size++;
    }

    public T pop(){
        Node payload = head;
        head = payload.next;
        size--;
        return payload.getData();
    }
}
class Assignment3 {
    public static void main(String[] args){
        Bag<Integer> test = new Bag<>(Integer.class, 2);
        test.add(1);
        test.add(2);
        test.add(3);
        test.add(3);
        test.add(3);
        test.add(4);
        test.remove(3);
        test.add(4);
        test.add(4);
        System.out.println(test.find(4));

        BagLinkedList<Integer> test2 = test.findAll(4);
        System.out.println(test2.pop());
        System.out.println(test2.pop());

    }
}
