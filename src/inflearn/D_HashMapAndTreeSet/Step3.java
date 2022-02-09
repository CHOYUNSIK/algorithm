package inflearn.D_HashMapAndTreeSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Step3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] a = new int[n];

        st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < n ; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }

        HashMap<Integer,Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0; i < m - 1 ; i++){
            map.put(a[i] , map.getOrDefault(a[i], 0)+1);
        }

        int lt = 0;

        for(int rt = m-1 ; rt < n ; rt ++){
            map.put(a[rt],map.getOrDefault(a[rt], 0)+1);
            list.add(map.size());
            map.put(a[lt],map.get(a[lt])-1);
            if(map.get(a[lt])==0) map.remove(a[lt]);
            lt++;
        }


        for(int x : list){
            System.out.print(x+ " ");
        }

   /*     HashSet<Integer> hs = new HashSet<>();

        int lt = 0;

        for(int rt = lt ; rt < n ; rt++ ){
            hs.add(a[rt]);
            if (rt == m+lt-1) {
                System.out.print(hs.size()+" ");
                hs.clear();
                rt = lt++;
            }
        }*/


    }
}
