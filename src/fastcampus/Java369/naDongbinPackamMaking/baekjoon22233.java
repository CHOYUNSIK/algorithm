package fastcampus.Java369.naDongbinPackamMaking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class baekjoon22233 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashSet<String> memos = new HashSet<>();

        for (int i = 0; i < N; i++) {
            memos.add(br.readLine());
        }

        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            if (str.contains(",")) {
                st = new StringTokenizer(str, ",");
                while (st.hasMoreTokens()) {
                    memos.remove(st.nextToken());
                }
                System.out.println(memos.size());
            } else {
                memos.remove(str);
                System.out.println(memos.size());
            }
        }

    }


}
