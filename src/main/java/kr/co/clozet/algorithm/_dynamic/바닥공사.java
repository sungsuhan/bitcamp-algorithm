package kr.co.clozet.algorithm._dynamic;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

/**
 * 가로의 길이 N, 세로의 길이가 2인 직사각형 형태의 얇은 바닥이 있다. 태일이는 이 얇은 바닥을 1x2의 덮개, 2x1의 덮개,
 * 2x2의 덮개를 이용해 채우자 한다. 이때 바닥을 채우는 모든 경우의 수를 구하는 프로그램을 작성하시오. 예를 들어 2x3 크기의
 * 바닥을 채우는 경우의 수는 5가지이다.
 * [입력 조건]
 * 첫째 줄에 N이 주어진다
 * [출력 조건]
 * 첫째 줄에 2xN 크기의 바닥을 채우는 방법의 수를 796,796 으로 나눈 나머지를 출력한다.
 * [입출력 예시]
 * N    return
 * 3    5
 *
 * packageName:kr.co.clozet.algorithm._dynamic
 * fileName        :바닥공사.java
 * author          : sungsuhan
 * date            :2022-05-25
 * desc            :
 * =============================================
 * DATE              AUTHOR        NOTE
 * =============================================
 * 2022-05-25           sungsuhan      최초 생성
 **/
public class 바닥공사 {

    @Builder @Getter @AllArgsConstructor @NoArgsConstructor
    public static class Solution{
        int n;
        int[] arr;
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
              e.arr = new int[e.n+1];
              e.arr[1] = 1;
              e.arr[2] = 3;

              for (int i = 3; i <= e.n; i++) {
                  e.arr[i] = e.arr[i-1] + e.arr[i-2] * 2;
              }

              e.answer = e.arr[e.n];

              return Solution.builder()
                      .answer(e.answer)
                      .build();
          };
          return f.solution(s);
        }
    }

    @Test
    public void testSolution(){
        int n = 3;

        Solution s = Solution.builder()
                .n(n)
                .build();
        Service s2 = new Service();
        System.out.println(s2.test(s));
    }

}
