package baekjoon.twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 두 수의 합
 * https://www.acmicpc.net/problem/3273
 */
public class B03273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());
        int[] numbers = new int[size];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int result = Integer.parseInt(br.readLine());

        Arrays.sort(numbers);

        int lt = 0;
        int rt = (size - 1);
        int count = 0;

        while (lt < rt) {
            int sum = (numbers[lt] + numbers[rt]);

            if (sum == result) {
                count++;
                sum -= numbers[lt];
                lt++;
            } else if (sum > result) {
                sum -= numbers[rt];
                rt--;
            } else {
                lt++;
            }
        }

        System.out.println(count);
    }
}
