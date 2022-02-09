package inflearn.H_DfsAndBfs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class Point4{
    int x;
    int y;
    public Point4(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Step15 {
    static int n, m, len ,result = Integer.MAX_VALUE;
    static ArrayList<Point4> hs , pz;
    static int[] combi;

    static void DFS(int L , int s){
        if(L == m){
            int sum = 0;
            for(Point4 p : hs){
                int dis = Integer.MAX_VALUE;
                for(int x : combi){
                    dis = Math.min(dis, Math.abs(p.x - pz.get(x).x) + Math.abs(p.y - pz.get(x).y));
                }
                sum += dis;
            }
            result= Math.min(result, sum);
        }else{
            for(int i = s; i < len; i++){
                combi[L] = i;
                DFS(L+1,i+1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner kb = new Scanner(System.in);
        n=kb.nextInt();
        m=kb.nextInt();
        pz=new ArrayList<>();
        hs=new ArrayList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                int tmp=kb.nextInt();
                if(tmp==1) hs.add(new Point4(i, j));
                else if(tmp==2) pz.add(new Point4(i, j));
            }
        }
        len=pz.size();
        combi=new int[m];
        DFS(0, 0);

        System.out.println(result);
    }
}
