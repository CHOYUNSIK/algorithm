package fastcampus.Java369.naDongbinPackamMaking;

import javax.xml.stream.events.Characters;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;


public class baekjoon21771 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int gaheeR = Integer.parseInt(st.nextToken());
        int gaheeC = Integer.parseInt(st.nextToken());

        int pillowsR = Integer.parseInt(st.nextToken());
        int pillowsC = Integer.parseInt(st.nextToken());


        int result = 0;

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            result += st.nextToken().chars().filter(value -> value == 'P').count();
        }

        if (result != pillowsR * pillowsC){
            System.out.println(1);
        }else {
            System.out.println(0);
        }


    }


}

