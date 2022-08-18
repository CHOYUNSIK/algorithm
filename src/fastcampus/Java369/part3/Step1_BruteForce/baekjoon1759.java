package fastcampus.Java369.part3.Step1_BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon1759 {

    static int L, C;
    static char[] arr;
    static int[] check;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new char[C + 1];
        check = new int[L + 1];


        st = new StringTokenizer(br.readLine(), " ");


        for (int i = 1; i <= C; i++) {
            arr[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(arr, 1, C + 1);

        dfs(1);

        System.out.println(sb);
    }


    static boolean isVowel(char x) {
        return x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u';
    }


    public static void dfs(int k) {

        if (k == L + 1) {

            int vower = 0, consonant = 0;


            for(int i = 1 ; i <= L; i++){
                if(isVowel(arr[check[i]])){
                    vower++;
                }else {
                    consonant++;
                }
            }
            if (vower >= 1 && consonant >= 2) {
                for(int i = 1 ; i <= L; i++){
                    sb.append(arr[check[i]]);
                }
                sb.append("\n");
            }
        } else {
            for (int i = check[k - 1] + 1; i <= C; i++) {
                check[k] = i;
                dfs(k + 1);
                check[k] = 0;
            }
        }

    }


}
