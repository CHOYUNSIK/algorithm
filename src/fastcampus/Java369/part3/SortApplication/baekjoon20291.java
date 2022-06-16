package fastcampus.Java369.part3.SortApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class baekjoon20291 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] list = new String[N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            list[i] = s.split("\\.")[1];
        }


        Arrays.sort(list);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; ) {

            int cnt = 1, j = i + 1;

            for (; j < N; j++) {
                if (list[j].compareTo(list[i]) == 0) {
                    cnt++;
                } else break;
            }

            sb.append(list[i]).append(" ").append(cnt).append("\n");

            i = j;
        }

        System.out.println(sb);

    }
}
