package baekjoon.twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 주몽
 * https://www.acmicpc.net/problem/1940
 */
public class B01940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int result = Integer.parseInt(br.readLine());

        int[] array = new int[size];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i ++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array);

        int lt = 0;
        int rt = (size - 1);
        int count = 0;

        while (lt < rt) {
            int sum = array[lt] + array[rt];

            if (sum < result) {
                lt++;
            } else if (sum > result) {
                rt--;
            } else {
                count++;
                lt++;
                rt--;
            }
        }

        System.out.println(count);
    }
}
