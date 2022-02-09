package inflearn.G_RecursiveAndTreeAndGraph;

class Node{
    int data;
    Node lt,rt;
    public Node(int val){
        this.data = val;
        lt=rt=null;
    }
}

public class Step5 {
    Node root;

    public void DFC(Node root){
        if(root == null) return;
        else{

            DFC(root.lt);
            DFC(root.rt);
            System.out.print(root.data+ " ");
        }
    }



    public static void main(String[] args) {
        Step5 tree = new Step5();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);
        tree.DFC(tree.root);
    }
}
