package hecto;


import java.util.ArrayList;
import java.util.List;

public class Step2 {

    public int solution(String s) {
        int n = s.length();
        String ss = s + s;

        int[] pi = new int[n];
        int j = 0;
        for (int i = 1; i < n; i++) {
            while (j > 0 && ss.charAt(i) != ss.charAt(j)) {
                j = pi[j - 1];
            }
            if (ss.charAt(i) == ss.charAt(j)) {
                pi[i] = ++j;
            }
        }

        int period = n - pi[n - 1];
        return (n % period == 0) ? period : n;
    }

    public static void main(String[] args) {
        Step2 solution = new Step2();
        String s1 = "abababab";
        String s2 = "abcabcaba";
        System.out.println(solution.solution(s1)); // 출력 결과: 2
        System.out.println(solution.solution(s2)); // 출력 결과: 9
    }
}
