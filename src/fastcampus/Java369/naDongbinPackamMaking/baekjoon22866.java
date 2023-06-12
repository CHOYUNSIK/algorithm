package fastcampus.Java369.naDongbinPackamMaking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class baekjoon22866 {

    static int[] height, building, cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        height = new int[N + 1];
        building = new int[N + 1];
        cnt = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 1; i <= N; i++) {
            height[i] = Integer.parseInt(st.nextToken());
        }

        function(1, N + 1, 1);
        function(N, 0, -1);

        for (int i = 1; i <= N; i++) {
          if (cnt[i] != 0) System.out.println(cnt[i] + " " + building[i]);
          else System.out.println(0);
        }

    }

    private static void function(int start, int end, int step) {

        Stack<Integer> stack = new Stack<>();

        while (start != end) {
            while (!stack.isEmpty() && height[start] >= height[stack.peek()]) stack.pop();
            if (!stack.isEmpty() && (building[start] == 0 || Math.abs(stack.peek() - start) < Math.abs(building[start] - start))) building[start] = stack.peek();
            cnt[start] += stack.size();
            stack.push(start);
            start += step;
        }

    }


}
