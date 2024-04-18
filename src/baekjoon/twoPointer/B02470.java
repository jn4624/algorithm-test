package baekjoon.twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 두 용액
 * https://www.acmicpc.net/problem/2470
 */
public class B02470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        int[] valueList = new int[count];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < count; i++) {
            valueList[i] = Integer.parseInt(st.nextToken());
        }

        int lt = 0;
        int rt = (count - 1);
        int ltValue = 0;
        int rtValue = 0;
        int min = Integer.MAX_VALUE;

        Arrays.sort(valueList);

        while (lt < rt) {
            int sum = valueList[lt] + valueList[rt];

            if (Math.abs(sum) < min) {
                min = Math.abs(sum);
                ltValue = valueList[lt];
                rtValue = valueList[rt];
            }

            if (sum > 0)  rt--;
            else lt++;
        }

        System.out.println(ltValue + " " + rtValue);
    }
}
