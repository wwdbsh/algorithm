package ds;

import java.io.*;
import java.util.*;

public class S2_1874 {
    
    public static void main(String[] args) throws IOException {
        
        System.setIn(new FileInputStream("../../inputs/s1874.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());

        Stack<Integer> s = new Stack<>();

        int num = 1;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int target = Integer.parseInt(st.nextToken());
            if (i == 0) {
                for (; num <= target; num++) {
                    s.push(num);
                    sb.append("+\n");
                }
                s.pop();
                sb.append("-\n");
            } else {

                 if (!s.isEmpty() && s.peek() == target) {
                    s.pop();
                    sb.append("-\n");
                } else {
                    if (num > target) {
                        while (!s.isEmpty() && s.peek() != target) {
                            s.pop();
                            sb.append("-\n");
                        }
                        if (s.isEmpty()) {
                            System.out.println("NO");
                            return;
                        }
                    } else {
                        for (; num <= target; num++) {
                            s.push(num);
                            sb.append("+\n");
                        }
                        s.pop();
                        sb.append("-\n");
                    }
                }

            }
        }

        System.out.println(sb.toString());
    }
}
