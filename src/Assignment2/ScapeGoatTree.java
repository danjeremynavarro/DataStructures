package Assignment2;

class ScapeGoatTree<T extends Comparable<T>> {

    Node<T> root = new Node();

    private class Node<T extends Comparable<T>>{
        protected T data;
        protected Node<T> left;
        protected Node<T> right;


        Node(){
            left = null;
            right = null;
            data = null;
        }
    }


}
