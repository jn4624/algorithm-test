package baekjoon.twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 용액
 * https://www.acmicpc.net/problem/2467
 */
public class B02467 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        int lt = 0;
        int rt = (size - 1);
        int ltValue = 0;
        int rtValue = 0;
        int min = Integer.MAX_VALUE;

        Arrays.sort(array);

        while (lt < rt) {
            int sum = (array[lt] + array[rt]);

            if (Math.abs(sum) <= min) {
                min = Math.abs(Math.abs(sum));

                ltValue = array[lt];
                rtValue = array[rt];
            }

            if (sum > 0) {
                rt--;
            } else {
                lt++;
            }
        }

        System.out.println(ltValue + " " + rtValue);
    }
}
