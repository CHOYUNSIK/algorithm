package inflearn.J_DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Step6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] dy = new int[m+1];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            for(int j = m; j >= t; j--){
                dy[j] = Math.max(dy[j], dy[j-t] + s);
            }
        }
        System.out.println(dy[m]);
    }
}
