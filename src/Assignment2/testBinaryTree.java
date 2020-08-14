package Assignment2;

import java.util.LinkedList;

public class testBinaryTree {

    public static void main (String[] args){
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
        LinkedList<Integer> sorted = test.getInorder();
        System.out.println(test.getInorderNext(10));
        sorted = test.getPreOrder();
        System.out.println(test.getPreOrderNext(15));
        sorted = test.getPostOrder();
        System.out.println(test.getPostOrderNext(15));
    }

}
