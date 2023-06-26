package hanwhalife;


import java.util.*;

public class Step3 {
    public int[][] solution(int N, int[][] bus_stops) {
        int[][] distances = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(distances[i], Integer.MAX_VALUE);
        }

        PriorityQueue<Node> queue = new PriorityQueue<>();
        for (int[] stop : bus_stops) {
            int row = stop[0] - 1;
            int col = stop[1] - 1;
            distances[row][col] = 0;
            queue.offer(new Node(row, col, 0));
        }

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            int row = current.row;
            int col = current.col;
            int distance = current.distance;

            if (distance > distances[row][col]) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nr = row + dr[i];
                int nc = col + dc[i];

                if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
                    continue;
                }

                int newDistance = distance + 1;


                if (newDistance < distances[nr][nc]) {
                    distances[nr][nc] = newDistance;
                    queue.offer(new Node(nr, nc, newDistance));
                }
            }
        }


        int[][] result = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                result[i][j] = distances[i][j];
            }
        }

        return result;
    }

    static class Node implements Comparable<Node> {
        int row;
        int col;
        int distance;

        public Node(int row, int col, int distance) {
            this.row = row;
            this.col = col;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.distance, other.distance);
        }
    }
    public static void main(String[] args) {
        Step3 solution = new Step3();

        // 예시 입력과 출력
        int N1 = 3;
        int[][] bus_stop1 = {{1, 2}};
        int[][] result1 = solution.solution(N1, bus_stop1);
        for (int[] row : result1) {
            System.out.println(Arrays.toString(row));
        }

        int N2 = 3;
        int[][] bus_stop2 = {{1, 2}, {3, 3}};
        int[][] result2 = solution.solution(N2, bus_stop2);
        for (int[] row : result2) {
            System.out.println(Arrays.toString(row));
        }
    }
}


