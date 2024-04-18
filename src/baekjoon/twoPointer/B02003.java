package baekjoon.twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 수들의 합 2
 * https://www.acmicpc.net/problem/2003
 */
public class B02003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());
        int result = Integer.parseInt(st.nextToken());
        int[] numbers = new int[size];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int lt = 0;
        int rt = 0;
        int sum = 0;
        int count = 0;

        while (true) {
            if (sum >= result) sum -= numbers[lt++];
            else if (rt == size) break;
            else sum += numbers[rt++];

            if (sum == result) count++;
        }

        System.out.println(count);
    }
}
