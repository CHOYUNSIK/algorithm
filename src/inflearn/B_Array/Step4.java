package inflearn.B_Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Step4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        /* 배열 이용하기
        int[] arr = new int[n];
        arr[0] = 1 ;
        arr[1] = 1 ;

        for(int i = 2 ; i < n; i++ ){
            arr[i]= arr[i-2] + arr[i-1];
        }

        for(int x : arr){
            System.out.print(x+" ");
        }*/

        int a=1 , b = 1, c ;
        System.out.print(a+" "+b+" ");
        for(int i =2 ; i < n ; i++){
            c=a+b;
            System.out.print(c+" ");
            a = b;
            b = c;
        }


        /* 재귀 이용하기
        for (int i = 1; i <= n; i++) {

            System.out.print(fibonacci(i)+ " ");

        }*/
    }
/* 재귀 이용하기 함수
public static int fibonacci(int n){
        if(n <= 1){
            return n;
        }
        return fibonacci(n-2)+ fibonacci(n-1);
    }*/
}
