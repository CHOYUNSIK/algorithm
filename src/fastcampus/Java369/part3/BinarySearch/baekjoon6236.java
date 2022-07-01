package fastcampus.Java369.part3.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon6236 {

    static int N, M;
    static int[] X;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        X = new int[N + 1];
        M = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            X[i] = Integer.parseInt(br.readLine());
        }

        int L = Arrays.stream(X).max().getAsInt(), R = 1000000000;

        int result = 0;

        while (L <= R) {
            int mid = (L + R) / 2;
            if (pocketMoneyCalculation(mid)) {
                R = mid - 1;
                result = mid;
            } else {
                L = mid + 1;
            }
        }

        System.out.println(result);

    }

    private static boolean pocketMoneyCalculation(int mid) {

        int count = 1, sum = 0;

        for(int i = 1; i <= N; i++){
            if(sum + X[i] > mid){
                count++;
                sum = X[i];
            }else {
                sum+= X[i];
            }
        }

        return count <= M;
    }


}
