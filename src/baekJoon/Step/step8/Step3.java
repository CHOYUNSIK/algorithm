package baekJoon.Step.step8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Step3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

        //입력받을 X 값
        //해당 범위의 대각선 개수 ( cross_count )
        //해당 대각선 직전 대각선 까지의 칸의 누적 합 ( prev_count_sum )
        int X = Integer.parseInt(br.readLine());
        int cross_count = 1, prev_count_sum = 0;


        while(true){

            if(X <= cross_count+prev_count_sum){

                if(cross_count%2 == 1){
                    System.out.print((cross_count - (X-prev_count_sum-1))+"/"+(X-prev_count_sum));
                    break;
                }else{
                    System.out.print((X-prev_count_sum)+"/"+(cross_count - (X-prev_count_sum-1)));
                    break;
                }

            }else {
                prev_count_sum += cross_count;
                cross_count++;
            }

        }

    }
}
