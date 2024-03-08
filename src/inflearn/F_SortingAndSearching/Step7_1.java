package inflearn.F_SortingAndSearching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Step7_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            list.add(new int[]{0,0});
        }



    }
}
