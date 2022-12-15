package fastcampus.Java369.mockCodingTest.Step02_CodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baekjoon21276 {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        ArrayList<String> list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            list.add(st.nextToken());
        }
        Collections.sort(list);


        String[] currentPeople = new String[N + 1];
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            currentPeople[i] = list.get(i - 1);
            map.put(currentPeople[i], i);
        }


        int M = Integer.parseInt(br.readLine());
        int[] numberOfAncestors = new int[N + 1];
        boolean[][] ancestralCheck = new boolean[N + 1][N + 1];

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String str1 = st.nextToken();
            String str2 = st.nextToken();

            int u = map.get(str1);
            int v = map.get(str2);

            numberOfAncestors[u]++;
            ancestralCheck[u][v] = true;

        }

        ArrayList<String> familyEponyms = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            if (numberOfAncestors[i] == 0) familyEponyms.add(currentPeople[i]);
        }

        int[] numberOfChild = new int[N + 1];
        boolean[][] childCheck = new boolean[N + 1][N + 1];
        for (int i = 0; i < N; i++) {
            int index = 1;
            while (numberOfAncestors[index] > 0) index++;

            for (int j = 1; j <= N; j++) {

                if (ancestralCheck[j][index]) {
                    numberOfAncestors[j]--;

                    if (numberOfAncestors[j] == 0) {
                        numberOfChild[index]++;
                        childCheck[index][j] = true;
                    }

                }

                numberOfAncestors[index] = 99999;

            }

        }

        System.out.println(familyEponyms.size());
        for (String s : familyEponyms) {
            System.out.print(s + " ");
        }
        System.out.println();

        for (int i = 1; i <= N; i++) {
            System.out.print(currentPeople[i] + " ");
            System.out.print(numberOfChild[i] + " ");
            for (int j = 1; j <= N; j++) {
                if (childCheck[i][j]) System.out.print(currentPeople[j] + " ");
            }
            System.out.println();
        }

    }


}
