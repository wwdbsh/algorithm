package hash;

import java.io.*;
import java.util.*;

public class S4_10816_Hash {

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("../../inputs/s10816.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();

        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int card = Integer.parseInt(st.nextToken());
            hm.put(card, hm.getOrDefault(card, 0) + 1);
        }
        
        st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            int card = Integer.parseInt(st.nextToken());
            sb.append(hm.getOrDefault(card, 0) + " ");
        }

        System.out.println(sb.toString());
    }
}
