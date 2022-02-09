package inflearn.C_TwoPointersAndSlidingWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Step1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n ; i ++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        int[] arr2 = new int[m];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < m ; i++){
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer> al = new ArrayList<>();

        int  p1 = 0 , p2 = 0;

        while (p1 < n && p2 < m){
            if(arr[p1] < arr2[p2]) al.add(arr[p1++]);
            else al.add(arr2[p2++]);
        }
        while(p1 < n) al.add(arr[p1++]);
        while(p2 < m) al.add(arr2[p2++]);

        for(int x : al){
            System.out.print(x + " ");
        }

    }
}
