package fastcampus.Java369.part3.Step2_SortApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon10825 {

    static class SubjectScore implements Comparable<SubjectScore> {
        String name;
        int language;
        int english;
        int mathematics;

        public SubjectScore(String name, int language, int english, int mathematics) {
            this.name = name;
            this.language = language;
            this.english = english;
            this.mathematics = mathematics;
        }

        @Override
        public int compareTo(SubjectScore o) {

            if (language != o.language) return o.language - language;
            if (english != o.english) return english - o.english;
            if (mathematics != o.mathematics) return o.mathematics - mathematics;
            return name.compareTo(o.name);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        SubjectScore[] subjectScoresList = new SubjectScore[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            subjectScoresList[i] = new SubjectScore(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(subjectScoresList);

        for (SubjectScore subjectScore : subjectScoresList) {
            System.out.println(subjectScore.name);
        }

    }
}