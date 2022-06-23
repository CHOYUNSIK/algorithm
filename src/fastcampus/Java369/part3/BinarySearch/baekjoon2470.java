package fastcampus.Java369.part3.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon2470 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] solution = new int[N + 1];


        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 1; i <= N; i++) {
            solution[i] = Integer.parseInt(st.nextToken());
        }


        Arrays.sort(solution, 1, N + 1);
        int best_sum = Integer.MAX_VALUE;
        int v1 = 0, v2 = 0;

        for (int i = 1; i <= N; i++) {
            int L = i + 1;
            int R = N;
            int X = -solution[i];

            int candidate = R + 1;

            while (L <= R) {
                int mid = (L + R) / 2;

                if (solution[mid] >= X) {
                    R = mid - 1;
                    candidate = mid;
                } else {
                    L = mid + 1;
                }

            }

            if (i < candidate - 1 && Math.abs(solution[i] + solution[candidate - 1]) < best_sum) {
                best_sum = Math.abs(solution[i] + solution[candidate - 1]);
                v1 = solution[i];
                v2 = solution[candidate - 1];
            }

            if (candidate <= N && Math.abs(solution[i] + solution[candidate]) < best_sum){
                best_sum = Math.abs(solution[i] + solution[candidate]);
                v1 = solution[i];
                v2 = solution[candidate];
            }


        }

        StringBuilder sb = new StringBuilder();
        sb.append(v1).append(' ').append(v2);
        System.out.println(sb);

    }

}
