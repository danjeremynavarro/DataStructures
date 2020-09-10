package Assignment2;
/**
 * Binary tree that has methods getPreOrder, getInorder, getPostOrder that returns a list
 * according to the traversal method
 */

import java.util.LinkedList;

class BinaryTree<T extends Comparable<T>>{

    protected Node<T> root = new Node<>();

    public void add(T d){
        if (root.data == null){
            root.data = d;
        } else {
            insert(root, d);
        }
    }

    protected Node<T> insert(Node<T> n, T d){
        if (n == null) {
            Node<T> newNode = new Node<>();
            newNode.data = d;
            return newNode;
        } else if (n.data.compareTo(d) > 0) {
            n.left = insert(n.left, d);
        } else if (n.data.compareTo(d) < 0){
            n.right = insert(n.right, d);
        }
        return n;
    }

    private T returnSortedNextValue(int sortMethod, T data){
        /**
         * @param sortMethod - 0 for inOrder , 1 for preOrder, 2 for postOrder
         */
        LinkedList<T> container = new LinkedList<>();
        switch(sortMethod){
            case 0:
                inOrder(root, container);
                break;
            case 1:
                preOrder(root, container);
                break;
            case 2:
                postOrder(root, container);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + sortMethod);
        }
        int elementLoc = container.indexOf(data) + 1;
        return container.get(elementLoc);
    }

    public LinkedList<T> getInorder(){
        LinkedList<T> container = new LinkedList<>();
        return inOrder(root, container);
    }

    private LinkedList<T> inOrder(Node d, LinkedList<T> container){
        if (d == null){
            return container;
        }
        inOrder(d.left, container);
        container.add((T) d.data);
        inOrder(d.right, container);
        return container;
    }

    public T getInorderNext(T d){
        return returnSortedNextValue(0, d);
    }

    public LinkedList<T> getPreOrder(){
        LinkedList<T> container = new LinkedList<>();
        preOrder(root, container);
        return container;
    }

    private LinkedList<T> preOrder(Node<T> d, LinkedList<T> container){
        if (d == null){
            return container;
        }
        container.add(d.data);
        preOrder(d.left, container);
        preOrder(d.right, container);
        return container;
    }

    public T getPreOrderNext(T d){
        return returnSortedNextValue(1, d);
    }

    public LinkedList<T> getPostOrder(){
        LinkedList<T> container = new LinkedList<>();
        postOrder(root, container);
        return container;
    }

    private LinkedList<T> postOrder(Node<T> d, LinkedList<T> container){
        if (d == null){
            return container;
        }
        postOrder(d.left, container);
        postOrder(d.right, container);
        container.add(d.data);
        return container;
    }

    public T getPostOrderNext(T d){
        return returnSortedNextValue(2, d);
    }

    public boolean isBinaryTree(){
        return recurseTree(root, null, null);
    }

    private boolean recurseTree(Node<T> root, Node left, Node right) {
        if (root == null)
            return true;

        if ( left != null && root.data.compareTo((T) left.data) < 0){
            return false;
        }

        if ( right != null && root.data.compareTo((T) right.data) > 0){
            return false;
        }

        return (recurseTree(root.left, left, root) && recurseTree(root.right, root , right));
    }


     class Node<T extends Comparable<T>>{
        protected T data;
        protected Node<T> left;
        protected  Node<T> right;

        Node(){
            left = null;
            right = null;
            data = null;
        }
    }
}
