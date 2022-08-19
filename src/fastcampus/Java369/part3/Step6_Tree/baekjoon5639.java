
package fastcampus.Java369.part3.Step6_Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class baekjoon5639 {

    static ArrayList<Integer> arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = "";
        arr = new ArrayList<>();
        while ((str = br.readLine()) != null) {
            arr.add(Integer.parseInt(str));
        }

        dfs5639(0, arr.size() - 1);
        System.out.println(sb);

    }


    private static void dfs5639(int l, int r) {
        if (l > r) return;
        int mid = r;

        for (int i = l + 1; i <= r; i++) {
            if (arr.get(i) > arr.get(l)) {
                mid = i - 1;
                break;
            }
        }

        dfs5639(l + 1, mid);
        dfs5639(mid + 1, r);
        sb.append(arr.get(l)).append("\n");

    }


}
