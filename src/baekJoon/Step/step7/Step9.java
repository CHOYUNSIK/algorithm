package baekJoon.Step.step7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Step9 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        String[] a = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

        int count = 0;

        for (int i = 0; i < a.length; i++) {
            while (s.contains(a[i])) {
                count++;
                s = s.replaceFirst(a[i], " ");
            }

        }
        s = s.replaceAll(" ", "");
        count += s.length();
        System.out.print(count);
    }
}
