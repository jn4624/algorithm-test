package baekjoon.twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 수열
 * https://www.acmicpc.net/problem/2559
 */
public class B02559 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 측정한 전체 날짜의 수
        int measurementDays = Integer.parseInt(st.nextToken());
        // 합을 구하기 위한 연속적인 날짜의 수
        int limitDays = Integer.parseInt(st.nextToken());
        // 측정한 온도
        int[] temperatures = new int[measurementDays];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < measurementDays; i++) {
            temperatures[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;

        for (int i = 0; i < limitDays; i++) {
            sum += temperatures[i];
        }

        int max = sum;

        for (int i = limitDays; i < measurementDays; i++) {
            sum += (temperatures[i]);
            sum -= (temperatures[i - limitDays]);
            max = Math.max(max, sum);
        }

        System.out.println(max);
    }
}
