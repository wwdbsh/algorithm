package ds;

import java.io.*;
import java.util.*;

public class S2_1927 {
    public static void main (String[] args) throws IOException {
        // 로컬 경로 유지
        System.setIn(new FileInputStream("../../inputs/s1927.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 첫 번째 줄 N 읽기
        int N = Integer.parseInt(br.readLine());

        // 1. 초기 용량 설정으로 리사이징 방지
        PriorityQueue<Integer> pq = new PriorityQueue<>(N);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            // 2. 한 줄에 숫자 하나만 있는 경우 더 빠른 파싱
            int x = Integer.parseInt(br.readLine());

            if (x == 0) {
                // 3. isEmpty() 사용 및 삼항 연산자로 간결화 가능
                if (pq.isEmpty()) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(pq.poll()).append("\n");
                }
            } else {
                pq.add(x);
            }
        }

        System.out.print(sb);
    }
}