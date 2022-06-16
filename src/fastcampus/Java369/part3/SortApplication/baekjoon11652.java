package fastcampus.Java369.part3.SortApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon11652 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[] numbers = new long[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            numbers[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(numbers);

        long mode = numbers[0];
        int modeCount = 1;
        int currentCount = 1;

        for (int i = 1; i < N; i++) {
            if (numbers[i - 1] == numbers[i]) {
                currentCount++;
            } else {
                currentCount = 1;
            }

            if (currentCount > modeCount) {
                mode = numbers[i];
                modeCount = currentCount;
            }
        }

        System.out.println(mode);

    }
}
