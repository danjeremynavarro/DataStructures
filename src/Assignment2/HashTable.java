package Assignment2;
import java.lang.Math;
class HashTableLinearProbed<T> {

    private Node<T> dummy = new Node<T>(null, null);

    private Class<T> dtype;

    private Node<T>[] table;

    private int tableSize;

    private int deleteNum = 0;

    private int nonNull = 0;

    private static int prime = 13;

    @SuppressWarnings("uncheked")
    HashTableLinearProbed(Class<T> clazz, int size){
        tableSize = size;
        table = new Node[size];
    }

    private static int getHash(String key){
        // Getting the absolute value of the hashcode and mixed with prime.
        double builtInHash = Math.abs(key.hashCode());
        return (int)builtInHash % prime;
    }

    public void put(String key, T value){
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
            if (currentNode.isKey(key)){
                keyNode = currentNode;
                data = keyNode.getData();
                table[keyHash] = dummy;
                deleteNum++;
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

    static class Node<T> {
        String key;
        T data;

        Node(String k, T val){
            key = k;
            data = val;
        }

        public boolean isKey(String k){
            return key.equals(k);
        }

        public T getData(){
            return data;
        }
    }
}



class HashTable {
    public static void main (String[] args){
        HashTableLinearProbed<Integer> test = new HashTableLinearProbed<>(Integer.class, 20);
        test.put("Test1", 123331);
        test.put("vcvb576", 23333);
        test.put("8887993", 244444);
        test.put("Test4", 2553456);
        test.put("Test5", 2121313);
        test.put("456", 232);
        System.out.println(test.get("456"));
        System.out.println(test.get("Test1"));
    }
}
