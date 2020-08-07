package Assignment2;

class BinaryTree<T>{

    Node<T> root = new Node<>();

    public void addNode(){

    }

    static class Node<T>{
        private T data;
        private Node<T> left;
        private Node<T> right;

        Node(){
            left = null;
            right = null;
            data = null;
        }

        public void setData(T d){
            data = d;
        }

        public T getData(){
            return data;
        }

        public void setLeft(Node<T> d){
            left = d;
        }

        public void setRight(Node<T> d){
            right = d;
        }

        public Node<T> getLeft(){
            return left;
        }

        public Node<T> getRight(){
            return right;
        }
    }
}
