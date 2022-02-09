package inflearn.K_ReferralProblem.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Step3 {

    static int L, C;
    static char[] arr;
    static boolean[] visited;

    static void dfs(int start, int dept, int ja, int mo) {
        for (int i = start; i < C; i++) {
            visited[i] = true;
            dfs(i + 1, dept + 1, ja + (check(arr[i]) ? 0 : 1), mo + (check(arr[i]) ? 1 : 0));
            visited[i] = false;
        }

        if (dept == L && ja >= 2 && mo >= 1) {
            for (int i = 0; i < C; i++) {
                if (visited[i]) {
                    System.out.print(arr[i]);
                }
            }
            System.out.println();
        }
    }

    static boolean check(char a) {
        if (a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u') {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[C];
        visited = new boolean[C];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < C; i++) {
            arr[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(arr);

        dfs(0,0,0,0);
    }

}
