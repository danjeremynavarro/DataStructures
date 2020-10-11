package Assignment2;

import java.util.Random;

@SuppressWarnings("ALL")
public class testHashTable {

    private static final String alphabet = " ABCDEFGHIJKLMNOPQRSTUVWXYZ01234567890abcdefghijklmnoqrstuvwxyz";
    private static final Random randomizer = new Random();

    public static void main(String[] args){
        /**
         * Answer to question 3 hash table implementation
         */
        int tableSize = 1000;
        HashTableLinearProbed<Integer> testTable = new HashTableLinearProbed<>();
        String[] keys = new String[tableSize];
        Integer[] values = new Integer[tableSize];

        // Create pair of random keys and values
        for (int i = 0; i < tableSize ; i++){
            keys[i] = generateRandomKey();
            values[i] = randomizer.nextInt(100000);
        }

        // Put into hash table
        for (int i = 0; i < tableSize ; i++){
            testTable.put(keys[i], values[i]);
        }

        /**
         * Check the accuracy of the returned values against the pair of keys array and values array
         * This will also check proper behavior when non existent keys are being accessed.
         */
        for (int i = 0; i < tableSize * 2 ; i++){
            int randomIndex = randomizer.nextInt(tableSize);
            String currentKey;

            // Every even check a non existent key
            if (i % 2 == 0){
                currentKey = generateRandomKey();
                assert(testTable.get(currentKey).equals(null));
            } else {
                currentKey = keys[randomIndex];
                Integer currentValue = values[randomIndex];
                assert(testTable.get(currentKey).equals(currentValue));
            }
        }

        System.out.println("Test completed");

    }

    private static String generateRandomKey(){
        int randomStringLength = randomizer.nextInt(50);
        StringBuilder newKey = new StringBuilder();

        for (int i = 0; i < randomStringLength; i++){
            newKey.append(alphabet.charAt(randomizer.nextInt(alphabet.length())));
        }
        return newKey.toString();
    }
}
