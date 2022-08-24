
package fastcampus.Java369.part3.Step6_Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class baekjoon1068 {

    static int n, root, removal;
    static ArrayList<Integer>[] child;
    static int[] leaf;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        child = new ArrayList[n];
        leaf = new int[n];

        for (int i = 0; i < n; i++) child[i] = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            int par = Integer.parseInt(st.nextToken());
            if (par == -1) {
                root = i;
                continue;
            }
            child[par].add(i);
        }

        removal = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            if (child[i].contains(removal)) {
                child[i].remove(child[i].indexOf(removal));
            }
        }

        if (root != removal) dfs1068(root, -1);

        System.out.println(leaf[root]);

    }

    private static void dfs1068(int x, int prev) {
        if (child[x].isEmpty()) {
            leaf[x]++;
        }

        for (int y : child[x]) {
            if (y == prev) continue;
            dfs1068(y, x);
            leaf[x] += leaf[y];
        }

    }
}
