package kr.co.clozet.algorithm._dynamic;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

/**
 * 계속되는 폭우로 일부 지역이 물에 잠겼습니다. 물에 잠기지 않은 지역을 통해 학교를 가려고 합니다.
 * 집에서 학교까지 가는 길은 m x n 크기의 격자모양으로 나타낼 수 있습니다. 아래 그림은 4 x 3 입니다.
 * 집 ㅁ ㅁ ㅁ
 * ㅁ 물 ㅁ ㅁ
 * ㅁ ㅁ ㅁ 학
 * 가장 왼쪽 위, 즉 집이 있는 곳의 좌표는 (1,1)로 나타내고 가장 오른쪽 아래, 즉 학교가 있는 곳의
 * 좌표는 (m,n)으로 나타냅니다. 격자의 크기 m, n 과 물이 잠긴 지역의 좌표를 담은 2차원 배열
 * puddles 이 매개변수로 주어집니다. 오른쪽과 아래쪽으로만 움직여 집에서 학교 까지 갈 수
 * 있는 최단경로의 개수를 1,000,000,007 로 나눈 나머지를 return 하도록 solution 함수를 작성해라.
 * [입출력 예]
 * m    n   puddles    return
 * 4    3   [[2,2]]    4
 *
 * packageName:kr.co.clozet.algorithm._dynamic
 * fileName        :등굣길.java
 * author          : sungsuhan
 * date            :2022-05-25
 * desc            : https://velog.io/@cgw0519/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EB%93%B1%EA%B5%A3%EA%B8%B8
 * =============================================
 * DATE              AUTHOR        NOTE
 * =============================================
 * 2022-05-25           sungsuhan      최초 생성
 **/
public class 등굣길 {

    @Builder @Getter @AllArgsConstructor @NoArgsConstructor
    public static class Solution{
        int m;
        int n;
        int[][] puddles;
        int[][] dp;
        int answer;

        @Override
        public String toString(){
            return String.format("%d", answer);
        }
    }

    @FunctionalInterface
    public interface SolutionService{
        Solution solution(Solution s);
    }

    class Service{
        Solution test(Solution s) {
          SolutionService f = e -> {
              e.dp = new int[e.n+1][e.m+1];

              for (int[] puddle : e.puddles)
                  e.dp[puddle[1]][puddle[0]] = -1;
              e.dp[0][1] = 1;

              for(int i=1; i<=e.m; i++){
                  for(int j=1; j<=e.n; j++){
                      if (e.dp[j][i] == -1) e.dp[j][i] = 0;
                      else e.dp[j][i] = (e.dp[j-1][i] + e.dp[j][i-1]) % 1000000007;
                  }

              }
              e.answer = e.dp[e.n][e.m];
              return Solution.builder()
                      .answer(e.answer)
                      .build();
          };
          return f.solution(s);
        }
    }

    @Test
    public void testSolution(){
        int m = 4;
        int n = 3;
        int[][] puddles = {{2,2}};

        Solution s = Solution.builder()
                .m(m)
                .n(n)
                .puddles(puddles)
                .build();
        Service s2 = new Service();
        System.out.println(s2.test(s));
    }

}
