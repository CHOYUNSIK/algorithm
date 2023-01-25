package fastcampus.Java369.naDongbinPackamMaking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon21918 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];

        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int command = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            switch (command) {
                case 1:
                    arr[x] = y;
                    break;
                case 2:
                    for (int j = x; j <= y; j++) {
                        int data = arr[j] == 1 ? 0 : 1;
                        arr[j] = data;
                    }
                    break;
                case 3:
                    for (int j = x; j <= y; j++) {
                        arr[j] = 0;
                    }
                    break;
                case 4:
                    for (int j = x; j <= y; j++) {
                        arr[j] = 1;
                    }
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(arr[i]).append(" ");
        }

        System.out.println(sb);
    }

}
