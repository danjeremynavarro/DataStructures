package Assignment2;

import java.lang.reflect.Array;

class HashTableLinearProbed<T> {

    private Node dummy = new Node(null, null);

    private Node[] table;

    private int tableSize;

    private int deleteNum = 0;

    private int nonNull = 0;

    private static int prime = 13;

    @SuppressWarnings("uncheked")
    HashTableLinearProbed(int size){
        tableSize = size;
        table = new Node[10];
    }

    private static int getHash(String key){
        int hashCode = key.hashCode();
        return hashCode % prime;
    }

    public void put(String key, T value){
        boolean isKeyFound = false;
        int keyHash = getHash(key);

        while(!isKeyFound){
            if (table[keyHash] == null){
                Node newNode = new Node(key, value);
                table[keyHash] = newNode;
                nonNull++;
                isKeyFound = true;
            } else {
                keyHash++;
            }
        }
    }

    public T get(String key){
        boolean isKeyFound = false;
        int keyHash = getHash(key);
        Node keyNode;
        T data = null;

        while(!isKeyFound){
            Node currentNode = table[keyHash];
            if (currentNode.isKey(key)){
                keyNode = currentNode;
                data = keyNode.getData();
                currentNode = dummy;
                deleteNum++;
                isKeyFound = true;
            } else if (currentNode == dummy) {
                // Return a null if key doesn't exist
                keyHash++;
            } else {
                isKeyFound = true;
            }
        }

        return data;
    }


    class Node<T> {
        String key;
        T data;

        Node(String k, T val){
            key = k;
            data = val;
        }

        public boolean isKey(String k){
            if(key.equals(k)){
                return true;
            } else {
                return false;
            }
        }

        public T getData(){
            return data;
        }
    }
}

class HashTable {
    public static void main (String[] args){
        HashTableLinearProbed<Integer> test = new HashTableLinearProbed<>(Integer.class, 20);
        test.put("Test1", 1);
        test.put("Test2", 2);
        test.put("Test3", 2);
        test.put("Test4", 2);
        test.put("Test5", 2);
        test.put("Test6", 2);
    }
}
