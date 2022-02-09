package inflearn.F_SortingAndSearching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Step8 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int[] a = new int[n];
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0 ; i < n ; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a);

        int lt = 0 ,rt = n-1;
        int count  = 0;

        while (lt <= rt){
            count ++;
            int mid = (lt+rt)/2;
            if(a[mid] == k){
                System.out.print(mid+1);
                break;
            }
            else if (k > a[mid]){
                lt = mid + 1;
            }else {
                rt = mid - 1;
            }
        }


    }
}
