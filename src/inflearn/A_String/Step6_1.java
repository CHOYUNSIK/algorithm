package inflearn.A_String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class Step6_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] charArray = br.readLine().toCharArray();

        LinkedHashSet<Character> set = new LinkedHashSet<>();

        for (int i = 0; i < charArray.length; i ++){
            set.add(charArray[i]);
        }

        StringBuilder sb = new StringBuilder();

        set.forEach(System.out::print);

    }
}
