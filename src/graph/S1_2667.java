package graph;

import java.io.*;
import java.util.*;

public class S1_2667 {

    static char[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int N;

    public static void main (String[] args) throws IOException {

        System.setIn(new FileInputStream("../../inputs/s2667.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());

        map = new char[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < line.length(); j++) {
                map[i][j] = line.charAt(j);
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == '1') {
                    pq.add(bfs(i, j));
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        sb.append(pq.size() + "\n");
        
        while (!pq.isEmpty()) {
            sb.append(pq.poll() + "\n");
        }
        System.out.print(sb.toString());
    }

    static int bfs (int x, int y) {
        
        int count = 1;

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{x, y});
        map[x][y] = '0';

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];

            for (int i = 0; i < 4; i++) {
                int ax = curX + dx[i];
                int ay = curY + dy[i];
                if (ax >= 0 && ay >= 0 && ax < N && ay < N && map[ax][ay] == '1') {
                    count++;
                    map[ax][ay] = '0';
                    queue.offer(new int[]{ax, ay});
                }

            }
        }

        return count;
    }
    
}
