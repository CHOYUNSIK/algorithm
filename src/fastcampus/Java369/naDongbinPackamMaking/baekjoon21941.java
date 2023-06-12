package fastcampus.Java369.naDongbinPackamMaking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class baekjoon21941 {

    static class Pair {
        int left;
        int right;

        public Pair(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int length = str.length();

        ArrayList<Pair>[] lists = new ArrayList[length];
        for (int i = 0; i < length; i++) {
            lists[i] = new ArrayList<>();
        }
        int[] DP = new int[length + 1];

        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            String rs = st.nextToken();
            int rsl = rs.length();
            int score = Integer.parseInt(st.nextToken());

            if (rsl >= score) continue;

            int idx = 0;

            while (idx < length){
                int cur = str.indexOf(rs, idx);
                if(cur == -1) break;
                lists[cur].add(new Pair(rsl, score));
                idx = cur + 1;
            }

        }

        for (int i = 0; i < length; i++){
            for (int j = 0; j < lists[i].size(); j++){
                int size = lists[i].get(j).left;
                int score = lists[i].get(j).right;

                DP[i + size] = Math.max(DP[i + size], DP[i] + score);
            }
            DP[i + 1] = Math.max(DP[i + 1] , DP[i] + 1);
        }

        System.out.println(DP[length]);

    }

}
