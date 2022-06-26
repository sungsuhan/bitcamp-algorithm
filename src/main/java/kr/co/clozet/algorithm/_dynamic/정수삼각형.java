package kr.co.clozet.algorithm._dynamic;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

/**
 *     7
 *    3 8
 *   8 1 0
 *  2 7 4 4
 * 4 5 2 6 5
 * 위와 같은 삼각형의 꼭대기에서 바닥까지 이어지는 경로 중, 거쳐간 숫자의 합이 가장 큰 경우를 찾아보려고 합니다. 아래 칸으로
 * 이동할 때는 대각선 방향으로 한 칸 오른쪽 또는 왼쪽으로만 이동 가능합니다. 예를 들어 3에서는 그 아래칸의 8 또는 1로만 이동이
 * 가능합니다. 삼각형의 정보가 담긴 배열 triangle 이 매개변수로 주어질 때, 거쳐간 숫가의 최댓값을 return 하도록 solution
 * 함수를 완성하세요.
 * [입출력 예]
 * triangle                                     result
 * [[7],[3,8],[8,1,0],[2,7,4,4],[4,5,2,6,5]]    30
 *
 * packageName:kr.co.clozet.algorithm._dynamic
 * fileName        :정수삼각형.java
 * author          : sungsuhan
 * date            :2022-05-25
 * desc            : https://lkhlkh23.tistory.com/117
 * =============================================
 * DATE              AUTHOR        NOTE
 * =============================================
 * 2022-05-25           sungsuhan      최초 생성
 **/
public class 정수삼각형 {

    @Builder @Getter @AllArgsConstructor @NoArgsConstructor
    public static class Solution{
        int[][] triangle;
        int[][] dp;
        int max;

        @Override
        public String toString(){
            return String.format("%d", max);
        }
    }

    @FunctionalInterface
    public interface SolutionService{
        Solution solution(Solution s);
    }

    class Service{
        Solution test(Solution s) {
          SolutionService f = e -> {
              e.dp = new int[e.triangle.length][e.triangle.length];
              e.dp[0][0] = e.triangle[0][0];
              for (int i = 1; i < e.triangle.length; i++) {
                  e.dp[i][0] = e.dp[i-1][0] + e.triangle[i][0];
                  e.dp[i][i] = e.dp[i-1][i-1] + e.triangle[i][i];
              }

              for (int i = 2; i < e.triangle.length; i++)
                  for (int j = 1; j < i; j++)
                      e.dp[i][j] = Math.max(e.dp[i-1][j-1], e.dp[i-1][j]) + e.triangle[i][j];

              e.max = 0;
              for (int i = 0; i < e.dp.length; i++)
                  e.max = Math.max(e.max, e.dp[e.dp.length - 1][i]);

              return Solution.builder()
                      .max(e.max)
                      .build();
          };
          return f.solution(s);
        }
    }

    @Test
    public void testSolution(){
        int[][] triangle = {{7},{3,8},{8,1,0},{2,7,4,4},{4,5,2,6,5}};

        Solution s = Solution.builder()
                .triangle(triangle)
                .build();
        Service s2 = new Service();
        System.out.println(s2.test(s));
    }

}
