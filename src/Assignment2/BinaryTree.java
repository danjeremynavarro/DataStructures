package Assignment2;

class BinaryTree<T extends Comparable<T>>{

    Node<T> root = new Node<>();

    public void add(T d){
        if (root.data == null){
            root.data = d;
        } else {
            insert(root, d);
        }
    }

    private Node<T> insert(Node<T> n, T d){
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

    private Node<T> traverseLeft(Node<T> currentNode){
        while(currentNode.left != null){
            traverseLeft(currentNode.left);
        }
        return currentNode;
    }


    static class Node<T extends Comparable<T>>{
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
