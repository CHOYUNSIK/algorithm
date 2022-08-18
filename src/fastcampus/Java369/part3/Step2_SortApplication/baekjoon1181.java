package fastcampus.Java369.part3.Step2_SortApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon1181 {


    static class Word implements Comparable<Word> {
        String name;

        public Word(String name) {
            this.name = name;
        }

        @Override
        public int compareTo(Word o) {

            if (this.name.length() != o.name.length()) {
                return this.name.length() - o.name.length();
            }

            return name.compareTo(o.name);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Word[] words = new Word[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            words[i] = new Word(st.nextToken());
        }

        Arrays.sort(words);

        for (int i = 0; i < N; i++) {
            if (i == 0 || !words[i - 1].name.equals(words[i].name)) {
                System.out.println(words[i].name);
            }
        }
    }
}