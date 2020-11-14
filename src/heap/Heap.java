package heap;
import java.util.Random;

class Node {
    public Node left, right, parent;
    public int x;
    Node(Node l, Node r, Node p, int d){
        left = l;
        right = r;
        parent = p;
        x = d;
    }
}

class MeldableHeap{
    private Random rand = new Random();
    Node root;
    boolean b = rand.nextBoolean();
    public void add(int x){
        Node u = new Node(null, null, null, x);
        root = meld(u,root);
    }

    public Node meld(Node n1, Node n2){
        if (n1 == null){
            return n2;
        }
        if (n2 == null){
            return n1;
        }

        if(n1.x > n2.x){
            return meld(n2,n1);
        }

        if(b){
            n1.left = meld(n1.left, n2);
            n1.left.parent = n1;
        } else {
            n1.right = meld(n1.right, n2);
            n1.right.parent = n1;
        }

        return n1;
    }

    public int remove(){
        int x = root.x;
        root = meld(root.left, root.right);
        if(root != null) {
            root.parent = null;
        }
        return x;
    }
}

public class Heap {
    public static void main (String[] args){
        MeldableHeap meldableHeap = new MeldableHeap();
        meldableHeap.add(10);
        meldableHeap.add(4);
        meldableHeap.add(9);
        meldableHeap.add(1);
        meldableHeap.remove();
        System.out.println(meldableHeap.remove());
    }
}
