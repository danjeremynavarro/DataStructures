package Assignment2;
import java.util.LinkedList;

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
