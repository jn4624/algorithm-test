package baekjoon.twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 부분합
 * https://www.acmicpc.net/problem/1806
 */
public class B01806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int numberSize = Integer.parseInt(st.nextToken());
        int result = Integer.parseInt(st.nextToken());
        int[] numbers = new int[numberSize + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numberSize; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int lt = 0;
        int rt = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;

        while (lt <= numberSize && rt <= numberSize) {
            if (sum >= result && min > (rt - lt)) min = (rt - lt);

            if (sum < result) sum += numbers[rt++];
            else sum -= numbers[lt++];
        }

        if (min == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(min);
        }
    }
}
