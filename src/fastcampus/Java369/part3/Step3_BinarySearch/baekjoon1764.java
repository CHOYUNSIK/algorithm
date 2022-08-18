package fastcampus.Java369.part3.Step3_BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baekjoon1764 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] A = new String[N + 1];
        String[] B = new String[M + 1];

        for (int a = 1; a <= N; a++) {
            A[a] = br.readLine();
        }

        for (int b = 1; b <= M; b++) {
            B[b] = br.readLine();
        }

        Arrays.sort(B, 1, M + 1);

        List<String> list = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            int L = 1;
            int R = M;
            String X = A[i];

            while (L <= R) {
                int mid = (L + R) / 2;
                if (X.compareTo(B[mid]) == 0) {
                    list.add(X);
                    break;
                }
                if (X.compareTo(B[mid]) > 0) {
                    L = mid + 1;
                } else {
                    R = mid - 1;
                }

            }


        }

        StringBuilder sb = new StringBuilder();

        sb.append(list.size()).append("\n");

        Collections.sort(list);

        for (String s : list) {
            sb.append(s).append("\n");
        }

        System.out.println(sb);

    }

}
