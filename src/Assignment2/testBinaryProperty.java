package Assignment2;

public class testBinaryProperty {
    public static void main (String[] args){
        /**
         * Answer to question 2
         * A method that checks if the binary tree satisfies the search order property
         */
        BinaryTree<Integer> test = new BinaryTree<>();
        test.add(10);
        test.add(2);
        test.add(4);
        test.add(14);
        test.add(10);
        test.add(15);
        test.add(13);
        test.add(1);
        test.add(20);
        System.out.println(test.isBinaryTree());
    }
}
