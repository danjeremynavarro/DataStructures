package Assignment2;
import java.lang.Math;
class HashTableLinearProbed<T> {
    /**
     * This implementation of the hashtable with linear probing demonstrates what happens
     * if there are too many collisions. Setting the random hash to return values of
     * of range 13 the table is guaranteed to run in linear time on any table size that is
     * more than 13
     */

    private Node<T> dummy = new Node<T>(null, null);

    private Node<T>[] table;

    private int tableSize = 15;

    private int deleteNum = 0;

    private int nonNull = 0;

    private static int prime = 13;

    @SuppressWarnings("uncheked")
    HashTableLinearProbed(){
        table = new Node[tableSize];
    }

    private int getHash(String key){
        // Getting the absolute value of the hashcode and mixed with prime.
        double builtInHash = Math.abs(key.hashCode());
        return (int)builtInHash % prime;
    }

    public void put(String key, T value){
        if (needResize()){
            resize();
        }

        boolean isKeyFound = false;
        int keyHash = getHash(key);
        while(!isKeyFound){
            if (table[keyHash] == null){
                Node<T> newNode = new Node<>(key, value);
                table[keyHash] = newNode;
                nonNull++;
                isKeyFound = true;
            } else {
                keyHash++;
            }
        }
    }

    public T get(String key){
        // Takes and deletes data by replacing with a dummy node
        boolean isKeyFound = false;
        int keyHash = getHash(key);
        Node<T> keyNode;
        T data = null;

        while(!isKeyFound){
            Node<T> currentNode = table[keyHash];

            if (currentNode.isKey(key) || currentNode != null){
                keyNode = currentNode;
                data = keyNode.getData();
                table[keyHash] = dummy;
                deleteNum++;
                nonNull--;
                isKeyFound = true;
                return data;
            } else if (currentNode == dummy) {
                // Return a null if key doesn't exist
                isKeyFound = true;
            } else {
                keyHash++;
            }
        }

        return data;
    }

    private void resize(){
        int newTableSize = tableSize * 2;
        Node<T>[] newTable = new Node[newTableSize];

        for(int i = 0; i < tableSize; i++){
            newTable[i] = table[i];
        }

        table = newTable;
        tableSize = newTableSize;
    }

    private boolean needResize(){
        return deleteNum + nonNull > tableSize / 2;
    }

    static class Node<T> {
        private String key;
        private T data;

        Node(String k, T val){
            key = k;
            data = val;
        }

        public boolean isKey(String k){
            if (key == null){
                return false;
            }
            return key.equals(k);
        }

        public T getData(){
            return data;
        }
    }
}

