package fastcampus.Java369.naDongbinPackamMaking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baekjoon21944 {


    static class Problem implements Comparable<Problem> {
        int first;
        int second;


        public Problem(int issueNumber, int second) {
            this.first = issueNumber;
            this.second = second;

        }

        @Override
        public int compareTo(Problem o) {
            if (this.first != o.first) return this.first - o.first;
            return this.second - o.second;

        }

    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());


        TreeSet<Problem>[] problemGroupList = new TreeSet[101];
        TreeSet<Problem> problemList = new TreeSet<>();
        HashMap<Integer, Problem> problemInfo = new HashMap<>();

        for (int i = 0; i < 101; i++) {
            problemGroupList[i] = new TreeSet<>();
        }


        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int P = Integer.parseInt(st.nextToken()); // 문제 번호
            int L = Integer.parseInt(st.nextToken()); // 난이도
            int G = Integer.parseInt(st.nextToken()); // 분류

            problemGroupList[G].add(new Problem(L, P));
            problemList.add(new Problem(L, P));
            problemInfo.put(P, new Problem(L, G));

        }

        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String statement = st.nextToken();

            switch (statement) {
                case "add":
                    int P = Integer.parseInt(st.nextToken()); // 문제 번호
                    int L = Integer.parseInt(st.nextToken()); // 난이도
                    int G = Integer.parseInt(st.nextToken()); // 분류

                    problemGroupList[G].add(new Problem(L, P));
                    problemList.add(new Problem(L, P));
                    problemInfo.put(P, new Problem(L, G));
                    break;
                case "recommend":
                    int g = Integer.parseInt(st.nextToken()); // 분류
                    int recommend = Integer.parseInt(st.nextToken());

                    if (recommend == 1) {
                        System.out.println(problemGroupList[g].last().second);
                    } else {
                        System.out.println(problemGroupList[g].first().second);
                    }
                    break;
                case "recommend2":
                    int recommend2 = Integer.parseInt(st.nextToken());

                    if (recommend2 == 1) {
                        System.out.println(problemList.last().second);
                    } else {
                        System.out.println(problemList.first().second);
                    }
                    break;
                case "recommend3":
                    int recommend3 = Integer.parseInt(st.nextToken());
                    int l = Integer.parseInt(st.nextToken());

                    if (recommend3 == 1) {
                        Problem higher = problemList.higher(new Problem(l, -1));

                        if (higher == null) System.out.println(-1);
                        else System.out.println(higher.second);
                    } else {
                        Problem lower = problemList.lower(new Problem(l, -1));
                        if (lower == null) System.out.println(-1);
                        else System.out.println(lower.second);
                    }
                    break;
                case "solved":
                    int solved = Integer.parseInt(st.nextToken());
                    Problem problem = problemInfo.get(solved);

                    problemGroupList[problem.second].remove(new Problem(problem.first, solved));
                    problemInfo.remove(solved);
                    problemList.remove(new Problem(problem.first, solved));

                    break;
            }

        }


    }


}
