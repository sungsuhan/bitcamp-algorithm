package kr.co.clozet.algorithm._sort;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * 하나의 수열에는 다양한 수가 존재한다
 * 이러한 수는 크기에 상관없이 나열되어 있다
 * 이 수를 큰 수부터 작은 수의 순서로 정렬해야 한다
 * 수열을 내림차순으로 정렬하는 프로그램을 만드시오.
 *
 * 입력 조건
 * 첫째 줄에 수열에 속해 있는 수의 개수 N이 주어진다 (1<=N<=500)
 * 둘째 줄부터 N+1번째 줄까지 N개의 수가 입력된다
 * 수의 범위는 1 이상 100,000 이하의 자연수이다
 *
 * 출력 조건
 * 입력으로 주어진 수열이 내림차순으로 정렬된 결과를 공백으로 구분하여 출력한다
 * 동일한 수의 순서는 자유롭게 출력하여도 괜찮다
 *
 * <입력 예시>
 * 3
 * 15
 * 27
 * 12
 * <출력 예시>
 * 27 15 12
 *
 * packageName:kr.co.clozet.algorithm._sort
 * fileName        :위에서아래로.java
 * author          : sungsuhan
 * date            :2022-05-25
 * desc            :
 * =============================================
 * DATE              AUTHOR        NOTE
 * =============================================
 * 2022-05-25           sungsuhan      최초 생성
 **/
public class 위에서아래로 {
    @Builder @Getter @NoArgsConstructor @AllArgsConstructor
    public static class Solution{
        int n;
        Integer[] arr;


        @Override
        public String toString(){
            return String.format(Arrays.toString(arr));
        }
    }

    @FunctionalInterface
    public interface SolutionService{
        Solution solution(Solution s);
    }

    class Service{
        Solution test(Solution s) {
            SolutionService f = e -> {

                Arrays.sort(e.arr, Collections.reverseOrder());

                return Solution.builder()
                        .n(e.n)
                        .arr(e.arr)
                        .build();
            };
            return f.solution(s);
        }
    }

    @Test
    public void testSolution(){
        int n = 3;
        Integer[] arr = {15, 27, 12};
        Solution s = Solution.builder()
                .n(n)
                .arr(arr)
                .build();
        Service s2 = new Service();
        System.out.println(s2.test(s));
    }


}
