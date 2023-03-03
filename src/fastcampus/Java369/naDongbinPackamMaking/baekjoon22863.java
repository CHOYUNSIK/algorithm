package fastcampus.Java369.naDongbinPackamMaking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// TODO: 풀지 못함
public class baekjoon22863 {

    static int N;
    static int[] S;
    static int[] D;
    static int[] order;
    static int[] used;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        S = new int[N + 1];
        D = new int[N + 1];
        order = new int[N + 1];
        used = new int[N + 1];
        result = new int[N + 1];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            D[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= N; i++) {
            if(used[i] == 1) continue;
            int siz = 0, j = i;
            while(true) {
                order[siz ++] = j;
                used[j] = 1;
                j = D[j];
                if(i == j) break;
            }
            for(j = 0; j < siz; j++) {
                int cur = order[j];
                int next = order[(int)((j + K) % siz)];
                result[next] = S[cur];
            }
        }


        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++) {
            sb.append(result[i]);
            sb.append(" ");
        }
        System.out.print(sb.toString());

    }


}
