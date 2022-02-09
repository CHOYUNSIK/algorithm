package inflearn.G_RecursiveAndTreeAndGraph;

import java.util.LinkedList;
import java.util.Queue;

class Node2{
    int data;
    Node2 lt,rt;
    public Node2(int val){
        this.data = val;
        lt=rt=null;
    }
}

public class Step7 {
    Node2 root;

    public void BFS(Node2 root){
        Queue<Node2> queue = new LinkedList<>();
        queue.add(root);
        int L = 0;
        while(!queue.isEmpty()){
            int len = queue.size();
            System.out.print(L+" : ");
            for(int i = 0; i < len; i++ ){
                Node2 cur = queue.poll();
                System.out.print(cur.data+ " ");
                if(cur.lt != null) queue.add(cur.lt);
                if(cur.rt != null) queue.add(cur.rt);
            }
            L++;
            System.out.println();
        }
    }



    public static void main(String[] args) {
        Step7 tree = new Step7();
        tree.root = new Node2(1);
        tree.root.lt = new Node2(2);
        tree.root.rt = new Node2(3);
        tree.root.lt.lt = new Node2(4);
        tree.root.lt.rt = new Node2(5);
        tree.root.rt.lt = new Node2(6);
        tree.root.rt.rt = new Node2(7);
        tree.BFS(tree.root);
    }
}
