package baekJoon.Step.step5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Step5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        double[] arr = new double[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < n ; i++ ){
            arr[i] = Double.parseDouble(st.nextToken());
        }
        Arrays.sort(arr);

        double max = arr[n-1];
        double result = 0;

        for(int i = 0; i < n; i++){
            arr[i] = (arr[i]/max)*100;
            result += arr[i];
        }
        //result = (result + max)/n;

        System.out.printf("%.5f",result/n);

    }
}
