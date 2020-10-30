/**
 * Assignment 2
 * Dan Jeremy Navarro
 * Oct 28, 2020
 */

package Assignment2;
import java.util.LinkedList;

/**
 * Returns a list of preorder, inorder or postorder sort of a binary tree. Data must implement comparable interface
 * Runs in O(n) time by visiting and storing nodes once visited using recursion
 * @param <T>
 */
public class NumberStore<T extends Comparable<T>> extends BinaryTree<T> {
    private LinkedList<T> preOrderNumber;
    private LinkedList<T> inOrderNumber;
    private LinkedList<T> postOrderNumber;

    public LinkedList<T> getPreOrderNumber(){
        preOrderNumber = getPreOrder();
        return preOrderNumber;
    }

    public LinkedList<T> getInOrderNumber(){
        inOrderNumber = getInorder();
        return inOrderNumber;
    }

    public LinkedList<T> getPostOrderNumber(){
        postOrderNumber = getPreOrder();
        return postOrderNumber;
    }
}
