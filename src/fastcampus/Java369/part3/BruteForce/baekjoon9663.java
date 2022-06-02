package fastcampus.Java369.part3.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon9663 {

    static int N, result = 0;
    static int[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        map = new int[N + 1];

        dfs(1);

        System.out.println(result);
    }


    public static void dfs(int x) {
        if (x == N + 1) {
            result++;
        } else {
            for (int i = 1; i <= N; i++) {

                if(check(x,i)){
                    map[x] = i;

                    dfs(x + 1);

                    map[x] = 0;
                }

            }
        }

    }

    public static boolean check(int x, int y) {
        for(int i = 1;  i <= x-1 ; i++){
            if(y == map[i]){
                return false;
            }
            if(x - y == i - map[i]){
                return false;
            }
            if(x + y == i + map[i]){
                return false;
            }
        }
        return true;
    }


}
