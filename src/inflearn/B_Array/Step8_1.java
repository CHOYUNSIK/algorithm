package inflearn.B_Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Step8_1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Integer[] score = new Integer[n];
        Integer[] result = new Integer[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < n; i++) {
            score[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            int num = 1;
            for (int j = 0; j < n; j++) {
                if (score[i] < score[j]) {
                    num++;
                }
            }
            result[i] = num;
        }

        for (int x : result) {
            System.out.print(x + " ");
        }
    }

}

