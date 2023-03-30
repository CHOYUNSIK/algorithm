package fastcampus.Java369.naDongbinPackamMaking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class baekjoon22867 {


    static class Pair implements Comparable<Pair> {
        String a;
        int b;

        public Pair(String a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Pair o) {
            return a.compareTo(o.a);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());


        ArrayList<Pair> list = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            list.add(new Pair(st.nextToken(), 1));
            list.add(new Pair(st.nextToken(), -1));
        }

        Collections.sort(list);

        int sum = 0, mx = 0;
        for (int i = 0; i < N * 2; i++) {
            sum += list.get(i).b;
            mx = Math.max(mx, sum);
        }

        System.out.println(mx);

    }


}
