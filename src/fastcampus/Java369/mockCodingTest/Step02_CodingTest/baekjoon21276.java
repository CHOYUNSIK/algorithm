package fastcampus.Java369.mockCodingTest.Step02_CodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baekjoon21276 {

    static int N, M;
    static String[] currentPerson;

    static ArrayList<String> name = new ArrayList<>();
    static HashMap<String, Integer> map = new HashMap<>();


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        currentPerson = new String[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 1; i <= N; i++) {
            name.add(st.nextToken());
        }

        Collections.sort(name);

        for (int i = 1; i <= N; i++) {
            currentPerson[i] = name.get(i - 1);
            map.put(name.get(i - 1), i);
        }

        M = Integer.parseInt(br.readLine());

        int[] parentCount = new int[N + 1];
        boolean[][] parentCheck = new boolean[N + 1][N + 1];

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            String a = st.nextToken();
            String b = st.nextToken();

            int u = map.get(a);
            int v = map.get(b);

            parentCount[u]++;
            parentCheck[u][v] = true;
        }

        ArrayList<String> supremeAncestor = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            if (parentCount[i] == 0) supremeAncestor.add(currentPerson[i]);
        }

        int[] childCount = new int[N + 1];
        boolean[][] childCheck = new boolean[N + 1][N + 1];
        for (int i = 0; i < N; i++) {
            int index = 1;
            while (parentCount[index] > 0) index++;
            for (int j = 1; j <= N; j++) {
                if (parentCheck[j][index]) {
                    parentCount[j]--;
                    if (parentCount[j] == 0) {
                        childCount[index]++;
                        childCheck[index][j] = true;
                    }
                }
            }

            parentCount[index] = 99999999;
        }


        System.out.println(supremeAncestor.size());
        for (String s : supremeAncestor) System.out.print(s + " ");
        System.out.println();

        for (int i = 1; i <= N; i++) {
            System.out.print(currentPerson[i] + " " + childCount[i] + " ");

            for (int j = 1; j <= N; j++) {
                if (childCheck[i][j]) {
                    System.out.print(currentPerson[j] + " ");
                }
            }
            System.out.println();
        }


    }


}
