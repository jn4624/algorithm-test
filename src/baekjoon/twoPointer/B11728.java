package baekjoon.twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 배열 합치기
 * https://www.acmicpc.net/problem/11728
 */
public class B11728 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int firstSize = Integer.parseInt(st.nextToken());
        int secondSize = Integer.parseInt(st.nextToken());
        int[] array = new int[firstSize + secondSize];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < firstSize; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < secondSize; i++) {
            array[firstSize + i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array);

        StringBuilder sb = new StringBuilder();
        for (int number : array) {
            sb.append(number).append(" ");
        }

        System.out.println(sb.toString());
    }
}
