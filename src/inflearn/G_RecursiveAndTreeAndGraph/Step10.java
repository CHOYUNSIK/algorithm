package inflearn.G_RecursiveAndTreeAndGraph;

import java.util.LinkedList;
import java.util.Queue;

class Node4{
    int data;
    Node4 lt, rt;
    public Node4(int val) {
        data=val;
        lt=rt=null;
    }
}

public class Step10 {
    static Node4 root;

    public int BFS(Node4 node) {
        Queue<Node4> q=new LinkedList<>();
        int level=0;
        q.offer(node);
        while (q.isEmpty()){
            int size=q.size();
            for (int i=0; i<size; i++) {
                Node4 temp=q.poll();
                if(temp.lt==null && temp.rt==null) return level;
                if (temp.lt!=null) q.offer(temp.lt);
                if (temp.rt!=null) q.offer(temp.rt);
            }
            level++;
        }
    return 0;
    }


    public static void main(String args[]) {
        Step10 tree=new Step10();
        tree.root=new Node4(1);
        tree.root.lt=new Node4(2);
        tree.root.rt=new Node4(3);
        tree.root.lt.lt=new Node4(4);
        tree.root.lt.rt=new Node4(5);
        System.out.println(tree.BFS(tree.root));
    }
}
