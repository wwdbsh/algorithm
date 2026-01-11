package search;

import java.io.*;
import java.util.*;

public class S2_1260 {
    static ArrayList<Integer>[] adj;
    static boolean[] visited;

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("../../inputs/s1260.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            adj[u].add(v);
            adj[v].add(u);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(adj[i]);
        }

        visited = new boolean[N + 1];
        dfs(V);
        System.out.println();

        visited = new boolean[N + 1];
        bfs(V);
    }

    static void dfs(int cur) {
        visited[cur] = true;
        System.out.print(cur + " ");
        for (int i = 0; i < adj[cur].size(); i++) {
            int next = adj[cur].get(i);
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

    static void bfs(int start) {
        Queue<Integer> queue = new ArrayDeque<>();

        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            System.out.print(cur + " ");

            for (int next : adj[cur]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
    }
}
