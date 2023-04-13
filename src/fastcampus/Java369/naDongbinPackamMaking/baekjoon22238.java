package fastcampus.Java369.naDongbinPackamMaking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Calc {

    public static long gcd(long x, long y) {
        long ny = x % y;

        if (x % y == 0) {
            return y;
        }

        return gcd(y, ny);
    }
}

class Direct {

    private final long x;

    private final long y;

    public Direct(long x, long y) {

        if (x != 0 && y != 0) {
            long g = Calc.gcd(Math.max(Math.abs(x), Math.abs(y)), Math.min(Math.abs(x), Math.abs(y)));
            this.x = x / g;
            this.y = y / g;
        } else if (x == 0) {
            this.y = ((y > 0) ? 1 : -1);
            this.x = 0;
        } else {
            this.x = ((x > 0) ? 1 : -1);
            this.y = 0;
        }


    }

    public long getX() {
        return x;
    }

    public long getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Direct direct = (Direct) o;
        return x == direct.x && y == direct.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}


public class baekjoon22238 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        long N = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        PriorityQueue<Long> queue = new PriorityQueue<>();
        Direct direct = new Direct(1, 1), att;


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            direct = new Direct(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
            queue.add(Long.parseLong(st.nextToken()));
        }

        long njDamage = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            att = new Direct(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));

            if (att.equals(direct)) {
                njDamage += Long.parseLong(st.nextToken());
                while (!queue.isEmpty() && queue.peek() <= njDamage) {
                    queue.poll();
                }
            }
            System.out.println(queue.size());
        }

    }


}
