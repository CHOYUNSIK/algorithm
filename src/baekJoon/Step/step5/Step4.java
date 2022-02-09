package baekJoon.Step.step5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.HashSet;

public class Step4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet hs = new HashSet<Integer>();


        for(int i = 0; i < 10; i++){
            hs.add( Integer.parseInt(br.readLine()) % 42);
        }

        System.out.println(hs.size());


    }
}
