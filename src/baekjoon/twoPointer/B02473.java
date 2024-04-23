package baekjoon.twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 세 용액
 * https://www.acmicpc.net/problem/2473
 */
public class B02473 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[] array = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(array);

        long min = Long.MAX_VALUE;
        int startValue = 0;
        int middleValue = 0;
        int endValue = 0;

        for (int i = 0; i < N - 2; i++) {
            int left = (i + 1);
            int right = (N - 1);

            while (left < right) {
                long sum = array[i] + array[left] + array[right];

                if (Math.abs(sum) < min) {
                    min = Math.abs(sum);
                    startValue = i;
                    middleValue = left;
                    endValue = right;
                }

                if (sum == 0) {
                    break;
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        System.out.println(array[startValue] + " " + array[middleValue] + " " + array[endValue]);
    }
}
