package baekjoon.twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 소수의 연속합
 * https://www.acmicpc.net/problem/1644
 */
public class B01644 {
    public static List<Integer> primeNumberList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        getPrimeNumberList(number);

        int lt = 0;
        int rt = 0;
        int sum = 2;
        int count = 0;

        while (lt < primeNumberList.size() && rt < primeNumberList.size()) {
            if (sum == number) {
                count++;
                sum -= primeNumberList.get(lt);
                lt++;
            } else if (sum > number) {
                sum -= primeNumberList.get(lt);
                lt++;
            } else {
                rt++;
                if (rt >= primeNumberList.size()) break;
                sum += primeNumberList.get(rt);
            }
        }

        System.out.println(count);
    }

    /**
     * 에라토스테네스의 체를 이용하여 소수 구하기
     */
    static void getPrimeNumberList(int number) {
        int[] temp = new int[number + 1];
        int rootN = (int) Math.sqrt(number);

        System.out.println("rootN = " + rootN);

        for (int i = 2; i <= number; i++) {
            temp[i] = i;
        }

        System.out.println("init temp = " + Arrays.toString(temp));

        for (int i = 2; i <= rootN; i++) {
            if (temp[i] != 0) {
                for (int j = (i + i); j <= number; j += i) {
                    temp[j] = 0;
                }
            }
        }

        System.out.println("prime temp = " + Arrays.toString(temp));

        for (int i = 2; i <= number; i++) {
            if (temp[i] != 0) {
                primeNumberList.add(temp[i]);
            }
        }
    }
}
