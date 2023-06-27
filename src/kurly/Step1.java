package kurly;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Step1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        n = n * m;

        int max = 0;

        while (n >= m) {
            int temp = n / m;
            max += temp;
            n = temp + (n % m);
        }

        System.out.println(max);


    }


}
