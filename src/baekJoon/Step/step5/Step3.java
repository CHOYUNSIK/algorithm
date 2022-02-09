package baekJoon.Step.step5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Step3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[10];

        int val = Integer.parseInt(br.readLine()) * Integer.parseInt(br.readLine()) * Integer.parseInt(br.readLine());

        String valS = String.valueOf(val);

        for(int i = 0; i < valS.length() ; i++){
            arr[valS.charAt(i) - '0']++;
        }
        for(int j = 0; j < arr.length; j++){
            System.out.println(arr[j]);
        }

    }
}
