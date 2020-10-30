package Assignment2;

import java.util.LinkedList;

public class testBinaryTree {

    public static void main (String[] args){
        /**
         * Answer to question 1
         * Worst case run time for all methods is O(n)
         * This is all the test case for question 5.
         * Use Binary tree in test plan to check results
         */
        NumberStore<Integer> test = new NumberStore<>();
        test.add(10);
        test.add(2);
        test.add(4);
        test.add(14);
        test.add(10);
        test.add(15);
        test.add(13);
        test.add(1);
        test.add(20);
        LinkedList<Integer> sorted = test.getInOrderNumber();
        System.out.println(test.getInorderNext(10));
        sorted = test.getPreOrderNumber();
        System.out.println(test.getPreOrderNext(15));
        sorted = test. getPostOrderNumber();
        System.out.println(test.getPostOrderNext(15));
    }

}
