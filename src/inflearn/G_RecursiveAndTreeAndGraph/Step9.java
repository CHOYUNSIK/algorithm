package inflearn.G_RecursiveAndTreeAndGraph;

class Node3{
    int data;
    Node3 lt, rt;
    public Node3(int val) {
        data=val;
        lt=rt=null;
    }
}

public class Step9 {
    static Node3 root;

    public int DFS(int depth, Node3 node) {
        if(node.lt==null && node.rt==null) return depth;
        else return Math.min(DFS(depth+1, node.lt), DFS(depth+1, node.rt));
    }

    public static void main(String args[]) {
        Step9 tree=new Step9();
        tree.root=new Node3(1);
        tree.root.lt=new Node3(2);
        tree.root.rt=new Node3(3);
        tree.root.lt.lt=new Node3(4);
        tree.root.lt.rt=new Node3(5);
        System.out.println(tree.DFS(0, tree.root));
    }
}
